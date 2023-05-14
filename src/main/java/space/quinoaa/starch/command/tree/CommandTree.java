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

import lombok.*;
import space.quinoaa.starch.command.ArgumentList;
import space.quinoaa.starch.command.ExecutionSpec;
import space.quinoaa.starch.command.handler.CommandHandler;
import space.quinoaa.starch.command.handler.Executor;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CommandTree implements CommandHandler {
	private final Map<String, CommandHandler> branchHandler;
	private final List<String> branches;
	private final Executor defaultHandler, unknownHandler;

	@Override
	public List<String> getCompletion(ExecutionSpec specs) {
		ArgumentList args = specs.getArgumentList();
		String request = args.consume();

		if(request == null) return Collections.emptyList();
		if(args.hasNext()){
			CommandHandler next = branchHandler.get(request);
			if(next != null) return next.getCompletion(specs);
			return Collections.emptyList();
		}

		return branches.stream()
				.filter(valid->valid.startsWith(request))
				.collect(Collectors.toList());
	}

	@Override
	public boolean handleCommand(ExecutionSpec specs) {
		String arg = specs.getArgumentList().consume();

		if(arg == null) return defaultHandler.handleCommand(specs);

		CommandHandler handler = branchHandler.get(arg);
		return handler != null ? handler.handleCommand(specs) : unknownHandler.handleCommand(specs);
	}


}
