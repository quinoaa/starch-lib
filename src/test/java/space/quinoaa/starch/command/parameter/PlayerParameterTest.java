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

package space.quinoaa.starch.command.parameter;

import org.bukkit.entity.Player;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import space.quinoaa.starch.command.ArgumentList;
import space.quinoaa.starch.command.ExecutionSpec;
import space.quinoaa.starch.command.executor.parameter.PlayerParameter;
import space.quinoaa.starch.mock.BukkitMock;

import java.util.List;

public class PlayerParameterTest {
	BukkitMock mock = BukkitMock.getOrCreate();

	@BeforeEach
	public void reset(){
		mock.reset();
	}

	@Test
	public void testComplete(){
		mock.addPlayer("player1");
		mock.addPlayer("player2");
		mock.addPlayer("player3");
		mock.addPlayer("idk");
		mock.addPlayer("abc");

		String[] args = {"pla"};
		PlayerParameter param = new PlayerParameter();
		ExecutionSpec specs = new ExecutionSpec(null, null, null, new ArgumentList(args));
		List<String> complete = param.getComplete(specs);

		Assertions.assertEquals(3, complete.size());
		Assertions.assertTrue(complete.contains("player1"));
		Assertions.assertTrue(complete.contains("player2"));
		Assertions.assertTrue(complete.contains("player3"));
		Assertions.assertFalse(complete.contains("idk"));
		Assertions.assertFalse(complete.contains("abc"));
	}

	@Test
	public void testParseValid(){
		mock.addPlayer("player1");
		Player plr2 = mock.addPlayer("player2");
		mock.addPlayer("player3");
		mock.addPlayer("idk");
		mock.addPlayer("abc");

		String[] args = {"player2"};
		PlayerParameter param = new PlayerParameter();
		ExecutionSpec specs = new ExecutionSpec(null, null, null, new ArgumentList(args));
		param.parse(specs);

		Assertions.assertTrue(param.isInputValid());
		Assertions.assertTrue(param.hasInput());
		Assertions.assertEquals(plr2, param.getInput());
	}

	@Test
	public void testParseInvalid(){
		mock.addPlayer("player1");
		mock.addPlayer("player2");
		mock.addPlayer("player3");
		mock.addPlayer("idk");
		mock.addPlayer("abc");

		String[] args = {"player5555"};
		PlayerParameter param = new PlayerParameter();
		ExecutionSpec specs = new ExecutionSpec(null, null, null, new ArgumentList(args));
		param.parse(specs);

		Assertions.assertFalse(param.isInputValid());
		Assertions.assertTrue(param.hasInput());
		Assertions.assertNull(param.getInput());
	}

}
