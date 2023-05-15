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

package space.quinoaa.starch.gui.component.slots;

public class RectangleSlotSet implements SlotSet {
	private final int x, y, width, height, inventoryWidth;

	public RectangleSlotSet(int x, int y, int width, int height) {
		if(width<=0 || height <=0) throw new IllegalStateException("width and height must be >0");
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.inventoryWidth = 9;
	}

	@Override
	public int getSlot(int index) {
		if(index >= getSlotCount() || index < 0) throw new IllegalStateException("Slot out of bound");
		int absX = x + index % width, absY = y + index / width;

		return absX + absY * inventoryWidth;
	}

	@Override
	public int getSlotIndex(int slotPosition) {
		int absX = slotPosition % inventoryWidth, absY = slotPosition / inventoryWidth;
		int rx = absX - x, ry = absY - y;

		if(rx < 0 || rx >= width || ry < 0 || ry >= height)
			throw new IllegalStateException("Slot out of bound. Please check with isSlot(slot_position)");

		return rx + ry * width;
	}

	@Override
	public boolean isSlot(int slotPosition) {
		int absX = slotPosition % inventoryWidth, absY = slotPosition / inventoryWidth;
		int rx = absX - x, ry = absY - y;

		return !(rx < 0 || rx >= width || ry < 0 || ry >= height);
	}

	@Override
	public int getSlotCount() {
		return width * height;
	}


}
