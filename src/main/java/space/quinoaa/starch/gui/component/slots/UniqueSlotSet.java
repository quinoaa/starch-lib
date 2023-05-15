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

public class UniqueSlotSet implements SlotSet {
	final int index;

	public UniqueSlotSet(int index) {
		this.index = index;
	}

	public UniqueSlotSet(int x, int y){
		this(x + y * 9);
	}


	@Override
	public int getSlot(int index) {
		if(index != 0) throw new IllegalStateException("Index out of bound.");
		return this.index;
	}

	@Override
	public int getSlotIndex(int slotPosition) {
		if(slotPosition != index) throw new IllegalStateException("Slot not in set.");
		return 0;
	}

	@Override
	public boolean isSlot(int slotPosition) {
		return slotPosition == index;
	}

	@Override
	public int getSlotCount() {
		return 1;
	}
}
