/*
 * MIT License
 *
 * Copyright (c) 2023 quinoaa
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package space.quinoaa.starch.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class GuiManager {
	private static final String GUI_KEY = "open_gui";
	private final JavaPlugin plugin;
	private Map<InventoryView, Gui> open = new HashMap<>();



	private GuiManager(JavaPlugin plugin){
		this.plugin = plugin;
	}



	public @Nullable Gui getGuiHandle(InventoryView view){
		return open.get(view);
	}

	public void open(Player player, Gui guiHandle){
		Inventory inv = guiHandle.getInventory();

		open.put(player.openInventory(inv), guiHandle);
	}



	private void registerTask(){
		Bukkit.getScheduler().runTaskTimer(plugin, this::tick, 1, 1);
	}

	private void tick() {
		open.forEach((view, gui)->{
			Player player = (Player) view.getPlayer();
			if(player.getOpenInventory() != view){
				plugin.getLogger().warning(player.getName() + " close event has been skipped. Please report this error. ");
				plugin.getLogger().warning("Gui class was " + gui.getClass().getName());
				return;
			}

			gui.tick(view);
		});
	}


	private class Handle implements Listener {

		@EventHandler
		public void onClick(InventoryClickEvent event){
			Gui gui = getGuiHandle(event.getView());
			if(gui == null) return;

			gui.onClick(event);
		}

		@EventHandler
		public void onDrag(InventoryDragEvent event){
			Gui gui = getGuiHandle(event.getView());
			if(gui == null) return;

			gui.onDrag(event);
		}

		@EventHandler
		public void onClose(InventoryCloseEvent event){
			Gui gui = open.remove(event.getView());
			if(gui == null) return;

			gui.onClose(event);
		}
	}

	public static GuiManager create(JavaPlugin plugin){
		GuiManager mgr = new GuiManager(plugin);

		Bukkit.getPluginManager().registerEvents(mgr.new Handle(), plugin);
		mgr.registerTask();

		return mgr;
	}

}
