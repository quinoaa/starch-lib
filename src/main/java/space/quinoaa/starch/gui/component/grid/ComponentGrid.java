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

package space.quinoaa.starch.gui.component.grid;

import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.jetbrains.annotations.Nullable;
import space.quinoaa.starch.gui.component.Component;
import space.quinoaa.starch.gui.component.slots.SlotSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the inventory grid. Handles what component is where.
 */
public class ComponentGrid {
	@Getter private final Inventory inventory;
	private final List<Component> components = new ArrayList<>();
	private final Component[] grid;

	public ComponentGrid(Inventory inventory) {
		this.inventory = inventory;
		grid = new Component[inventory.getSize()];
	}


	public void addComponent(Component component, SlotSet slots){
		Painter painter = new Painter(slots, this, component);
		components.add(component);

		for (int i = 0; i < slots.getSlotCount(); i++) {
			int slot = slots.getSlot(i);

			if(grid[slot] != null) continue;
			grid[slot] = component;
		}

		component.init(painter);
	}


	public @Nullable Component getComponent(int index){
		return grid[index];
	}


	public void onOpen(Player player, InventoryView view) {
		components.forEach(component -> component.onOpen(player, view));
	}

	public void onClick(InventoryClickEvent event){
		Component component = grid[event.getSlot()];
		if(component == null) return;

		int slot = component.getSlots().getSlotIndex(event.getSlot());
		component.onComponentClick(event, slot);
	}

	public void onClose(InventoryCloseEvent event) {
		components.forEach(component -> component.onClose(event));
	}
}
