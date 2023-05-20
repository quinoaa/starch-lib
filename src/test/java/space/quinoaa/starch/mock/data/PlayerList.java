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

package space.quinoaa.starch.mock.data;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;
import space.quinoaa.starch.mock.MockPlayer;

import java.util.*;

public class PlayerList {
	private final List<Player> players = new ArrayList<>();
	private final Map<String, Player> nameMapping = new HashMap<>();

	public Player addPlayer(String name){
		if(nameMapping.containsKey(name)) throw new IllegalStateException("Player already exists");

		MockPlayer player = new MockPlayer(name);
		players.add(player);
		nameMapping.put(name, player);

		return player;
	}

	public Collection<Player> getPlayerList(){
		return new ArrayList<>(players);
	}

	public @Nullable Player getPlayer(String name){
		return nameMapping.get(name);
	}
}
