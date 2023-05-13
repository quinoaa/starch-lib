/*
 * MIT License
 * Copyright (c)  quinoaa 2023.
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
 */

package space.quinoaa.starch.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class GuiHandler implements Listener {
	private Map<InventoryView, Gui> openedGui = new HashMap<>();
	private JavaPlugin plugin;

	/**
	 * Registers the GuiHandler's listeners.
	 * @param plugin owning the gui handler.
	 */
	public void init(JavaPlugin plugin){
		if(this.plugin != null) throw new IllegalStateException("Already initialized");
		this.plugin = plugin;
	}

	/**
	 * Make the player open the gui.
	 */
	public void open(Gui gui, Player player) {
		if(plugin == null) throw new IllegalStateException("GuiHandler has not been initialized");

		InventoryView view = player.openInventory(gui.getInventory());
		openedGui.put(view, gui);
		gui.onOpen(player, view);
	}

	@EventHandler
	protected void onClick(InventoryClickEvent event){
		InventoryView view = event.getView();
		Gui gui = openedGui.get(view);

		if(gui != null) gui.onClick(event);
	}

	@EventHandler
	protected void onDrag(InventoryDragEvent event){
		InventoryView view = event.getView();
		Gui gui = openedGui.get(view);

		if(gui != null) gui.onDrag(event);
	}

	@EventHandler
	protected void onClose(InventoryCloseEvent event){
		Gui gui = openedGui.remove(event.getView());

		if(gui != null) gui.onClose(event);
	}


}
