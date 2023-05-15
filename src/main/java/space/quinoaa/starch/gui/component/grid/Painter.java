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
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;
import space.quinoaa.starch.gui.component.Component;
import space.quinoaa.starch.gui.component.slots.SlotSet;

/**
 * The painter makes sure that the component doesn't draw outside its bounds.
 */
public class Painter {
	@Getter private final SlotSet slots;
	private final ComponentGrid grid;
	private final Component component;
	private final Inventory inventory;
	@Getter	private boolean disposed = false;

	public Painter(SlotSet slots, ComponentGrid grid, Component component) {
		this.grid = grid;
		this.slots = slots;
		this.component = component;
		this.inventory = grid.getInventory();

	}

	public void setItem(int index, ItemStack item){
		if(disposed) return;
		int slot = slots.getSlot(index);

		if(grid.getComponent(slot) != component) return;
		inventory.setItem(slot, item);
	}

	public @Nullable ItemStack getItem(int index){
		int slot = slots.getSlot(index);

		if(grid.getComponent(slot) != component) return null;
		return inventory.getItem(slot);
	}

	public int getSlotCount(){
		return slots.getSlotCount();
	}

	public void dispose(){
		disposed = true;
	}
}
