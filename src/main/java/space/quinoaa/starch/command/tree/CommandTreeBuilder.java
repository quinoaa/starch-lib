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

package space.quinoaa.starch.command.tree;

import lombok.NoArgsConstructor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;
import space.quinoaa.starch.command.executor.ExecutorBuilder;
import space.quinoaa.starch.command.handler.CommandHandler;
import space.quinoaa.starch.command.handler.Executor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

@NoArgsConstructor
public class CommandTreeBuilder {
	private final Map<String, CommandHandler> branchHandler = new HashMap<>();
	private final List<String> branches = new ArrayList<>();
	private Executor defaultHandler = s -> false, unknownHandler = s -> false;




	public CommandTreeBuilder addBranch(String name, CommandHandler handler) {
		if (branchHandler.containsKey(name))
			throw new IllegalStateException("Branch already exists: " + name);

		branchHandler.put(name, handler);
		branches.add(name);

		return this;
	}

	public CommandTreeBuilder addSubTree(String name, Consumer<CommandTreeBuilder> init) {
		CommandTreeBuilder builder = new CommandTreeBuilder();
		init.accept(builder);
		return addBranch(name, builder.build());
	}

	public CommandTreeBuilder addExecutor(String name, ExecutorBuilder.ExecutorSupplier supplier) {
		return addBranch(name, new ExecutorBuilder(supplier));
	}




	public CommandTreeBuilder setDefaultHandler(Executor defaultHandler) {
		this.defaultHandler = defaultHandler;
		return this;
	}

	public CommandTreeBuilder setUnknownHandler(Executor unknownHandler) {
		this.unknownHandler = unknownHandler;
		return this;
	}



	public CommandTree build() {
		return new CommandTree(branchHandler, branches, defaultHandler, unknownHandler);
	}



	public void register(PluginCommand command) {
		CommandTree tree = build();
		command.setExecutor(tree);
		command.setTabCompleter(tree);
	}

	public void register(JavaPlugin plugin, String commandName) {
		register(plugin.getCommand(commandName));
	}
}
