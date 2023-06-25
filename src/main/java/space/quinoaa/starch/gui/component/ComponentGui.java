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

package space.quinoaa.starch.gui.component;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import space.quinoaa.starch.gui.Gui;
import space.quinoaa.starch.gui.component.grid.ComponentGrid;
import space.quinoaa.starch.gui.component.slots.SlotSet;

public class ComponentGui implements Gui {
	final Inventory inventory;
	ComponentGrid grid;

	public ComponentGui(Inventory inventory) {
		this.inventory = inventory;
		clearComponents();
	}



	public void clearComponents(){
		inventory.clear();
		grid = new ComponentGrid(inventory);
	}

	public void addComponent(Component component, SlotSet slots){
		grid.addComponent(component, slots);
	}



	@Override
	public Inventory getInventory() {
		return inventory;
	}

	@Override
	public void onOpen(Player player, InventoryView view) {
		grid.onOpen(player, view);
	}

	@Override
	public void onClick(InventoryClickEvent event) {
		if(event.getClick() != ClickType.LEFT && event.getClick() != ClickType.RIGHT) {
			event.setCancelled(true);
			return;
		}
		if(event.getClickedInventory() != event.getView().getTopInventory()) return;

		grid.onClick(event);
	}

	@Override
	public void onDrag(InventoryDragEvent event) {
		event.setCancelled(true);
	}

	@Override
	public void onClose(InventoryCloseEvent event) {
		grid.onClose(event);
	}
}
