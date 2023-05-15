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

package space.quinoaa.starch.gui.component.base;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import space.quinoaa.starch.gui.component.Component;

public class Button extends Component {
	final ItemProvider itemProvider;
	final ClickHandler clickHandler;

	public Button(ItemStack item, ClickHandler clickHandler) {
		this.itemProvider = i->item;
		this.clickHandler = clickHandler;
	}

	public Button(ItemProvider itemProvider, ClickHandler clickHandler) {
		this.itemProvider = itemProvider;
		this.clickHandler = clickHandler;
	}


	@Override
	public void init() {
		getPainter().getSlots().iterateIndexes(index->getPainter().setItem(index, itemProvider.getItemStack(index)));
	}

	@Override
	public void onComponentClick(InventoryClickEvent event, int slotIndex) {
		event.setCancelled(true);
		clickHandler.onClick(event, slotIndex);
	}
}
