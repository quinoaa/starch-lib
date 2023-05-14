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

package space.quinoaa.starch.command.executor.parameter;

import lombok.NonNull;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import space.quinoaa.starch.command.ExecutionSpec;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PlayerParameter implements Parameter<Player> {
	private String playerName = null;
	private Player player = null;
	@Setter @NonNull private Function<Player, Boolean> playerPredicate = p->true;



	@Override
	public void parse(ExecutionSpec spec) {
		playerName = spec.getArgumentList().consume();
		if(playerName == null) return;

		Player check = Bukkit.getPlayerExact(playerName);
		if(playerPredicate.apply(check)) player = check;
	}



	@Override
	public boolean hasInput() {
		return playerName != null;
	}

	@Override
	public boolean isInputValid() {
		return player != null;
	}

	@Override
	public Player getInput() {
		return player;
	}

	@Override
	public List<String> getRawInput() {
		return playerName != null ? Collections.singletonList(playerName) : Collections.emptyList();
	}



	@Override
	public List<String> getComplete(ExecutionSpec spec) {
		String start = spec.getArgumentList().consume();
		if(start == null) return Collections.emptyList();

		return Bukkit.getOnlinePlayers()
				.stream()
				.filter(playerPredicate::apply)
				.map(Player::getName)
				.filter(name->name.startsWith(start))
				.collect(Collectors.toList());
	}
}
