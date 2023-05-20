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

import be.seeseemelk.mockbukkit.MockBukkit;
import be.seeseemelk.mockbukkit.MockPlugin;
import be.seeseemelk.mockbukkit.ServerMock;
import be.seeseemelk.mockbukkit.entity.PlayerMock;
import org.bukkit.command.Command;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import space.quinoaa.starch.command.ArgumentList;
import space.quinoaa.starch.command.ExecutionSpec;
import space.quinoaa.starch.command.executor.parameter.WordParameter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordParameterTest {
	final String alias = "testcmd";
	ServerMock server;
	PlayerMock player;
	MockPlugin plugin;
	Command cmd;


	@Before
	public void prepare(){
		server = MockBukkit.mock();
		player = server.addPlayer();
		plugin = MockBukkit.createMockPlugin("idontknow");
		cmd = plugin.getCommand(alias);
	}

	@Test
	public void testExecute(){
		final String[] args = {"one", "two", "three"};
		ExecutionSpec spec = new ExecutionSpec(player, cmd, alias, new ArgumentList(args));

		for (int i = 0; i < args.length; i++) {
			WordParameter word = new WordParameter();
			word.parse(spec);
			Assertions.assertEquals(args[i], word.getInput());
			Assertions.assertTrue(word.isInputValid());
			Assertions.assertTrue(word.hasInput());
		}
	}

	@Test
	public void testSpecificValid(){
		final String[] args = {"allowed"};
		ExecutionSpec spec = new ExecutionSpec(player, cmd, alias, new ArgumentList(args));

		WordParameter param = new WordParameter();
		Set<String> available = new HashSet<>();
		available.add(args[0]); available.add("random_str"); available.add("random_str2");
		param.setAvailableWords(available);

		param.parse(spec);
		Assertions.assertEquals(args[0], param.getInput());
		Assertions.assertTrue(param.isInputValid());
		Assertions.assertTrue(param.hasInput());
	}

	@Test
	public void testSpecificInvalid(){
		final String[] args = {"not_allowed"};
		ExecutionSpec spec = new ExecutionSpec(player, cmd, alias, new ArgumentList(args));

		WordParameter param = new WordParameter();
		Set<String> available = new HashSet<>();
		available.add("random_str"); available.add("random_str2");
		param.setAvailableWords(available);

		param.parse(spec);
		Assertions.assertNull(param.getInput());
		Assertions.assertFalse(param.isInputValid());
		Assertions.assertFalse(param.hasInput());
	}

	@Test
	public void testComplete(){
		final String[] args = {"start"};
		ExecutionSpec spec = new ExecutionSpec(player, cmd, alias, new ArgumentList(args));

		WordParameter param = new WordParameter();
		Assertions.assertEquals(param.getComplete(spec).size(), 0);
	}

	@Test
	public void testCompleteSpecific(){
		final String[] args = {"start"};
		Set<String> available = new HashSet<>(Arrays.asList("idk", "start_one", "start_two", "other"));
		ExecutionSpec spec = new ExecutionSpec(player, cmd, alias, new ArgumentList(args));

		WordParameter param = new WordParameter();
		param.setAvailableWords(available);

		List<String> ret = param.getComplete(spec);

		Assertions.assertEquals(2, ret.size());
		Assertions.assertTrue(ret.contains("start_one"));
		Assertions.assertFalse(ret.contains("idk"));
	}

	@After
	public void dispose(){
		MockBukkit.unmock();
	}
}
