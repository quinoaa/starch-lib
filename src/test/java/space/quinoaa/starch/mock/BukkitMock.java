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

package space.quinoaa.starch.mock;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import space.quinoaa.starch.mock.data.MockData;

@Getter
public class BukkitMock {
	private static BukkitMock instance = null;

	private final MockData data = new MockData();
	private final ServerMock server = new ServerMock(data);


	public Player addPlayer(String name) {
		return data.getPlayerList().addPlayer(name);
	}


	public void reset() {
		data.reset();
	}







	public static BukkitMock getOrCreate(){
		if(instance == null){
			BukkitMock mock = new BukkitMock();

			Bukkit.setServer(mock.server);
			instance = mock;
		}

		return instance;
	}
}
