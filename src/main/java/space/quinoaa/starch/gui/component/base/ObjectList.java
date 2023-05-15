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

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import space.quinoaa.starch.gui.component.Component;
import space.quinoaa.starch.gui.component.grid.Painter;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

@RequiredArgsConstructor
public class ObjectList<T> extends Component {
	private final Function<T, ItemStack> itemRenderer;
	private final Consumer<T> clickHandler;
	private final ItemStack emptyItem;
	private List<T> objects = null;
	@Getter private int pageCount, currentPage, itemPerPage;

	public ObjectList(Function<T, ItemStack> itemRenderer) {
		this(itemRenderer, t->{});
	}

	public ObjectList(Function<T, ItemStack> itemRenderer, Consumer<T> clickHandler) {
		this(itemRenderer, clickHandler, null);
	}

	public void updateList(){
		updatePages();
		renderList();
	}

	public void setCurrentPage(int page){
		int lastPage = currentPage;
		currentPage = page;
		updatePages();

		if(lastPage != currentPage) renderList();
	}

	public void movePage(int pageCount){
		setCurrentPage(currentPage + pageCount);
	}

	public void updatePages(){
		if(objects == null){
			pageCount = 1; currentPage = 0;
		}else{
			pageCount = objects.size() / itemPerPage;
			if(pageCount == 0) pageCount = 1;

			currentPage = Math.min(Math.max(currentPage, 0), pageCount - 1);
		}
	}

	public void setList(List<T> objects){
		this.objects = objects;
		updateList();
	}

	public void renderList(){
		Painter painter = getPainter();
		int startIndex = currentPage * itemPerPage;

		getSlots().iterateIndexes(index->{
			int listIndex = index + startIndex;
			if(listIndex < 0 || listIndex >= objects.size()) painter.setItem(index, emptyItem);

			ItemStack item = itemRenderer.apply(objects.get(listIndex));
			painter.setItem(index, item);
		});
	}


	@Override
	public void init() {
		itemPerPage = getSlots().getSlotCount();

		updateList();
	}

	@Override
	public void onComponentClick(InventoryClickEvent event, int slotIndex) {
		event.setCancelled(true);

		int startIndex = currentPage * itemPerPage;
		int listIndex = slotIndex + startIndex;

		if(listIndex < 0 || listIndex >= objects.size()) return;
		T ins = objects.get(listIndex);
		clickHandler.accept(ins);
	}


}
