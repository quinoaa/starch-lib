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

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import space.quinoaa.starch.gui.component.Component;

@RequiredArgsConstructor
public class Label extends Component {
	private @NonNull ItemProvider itemProvider;

	public Label(ItemStack item) {
		itemProvider = i->item;
	}


	public void setItemProvider(@NonNull ItemProvider provider){
		itemProvider = provider;
		redraw();
	}

	public void setItem(ItemStack item){
		setItemProvider(i->item);
	}

	public void redraw(){
		getPainter().getSlots().iterateIndexes(index->getPainter().setItem(index, itemProvider.getItemStack(index)));
	}


	@Override
	public void init() {
		redraw();
	}

	@Override
	public void onComponentClick(InventoryClickEvent event, int slotIndex) {
		event.setCancelled(true);
	}
}
