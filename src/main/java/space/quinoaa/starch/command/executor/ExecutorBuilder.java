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

package space.quinoaa.starch.command.executor;

import space.quinoaa.starch.command.ExecutionSpec;
import space.quinoaa.starch.command.handler.CommandHandler;

import java.util.List;

public class ExecutorBuilder implements CommandHandler {
	final ExecutorSupplier executionSupplier;
	final ParameterList parameters;

	public ExecutorBuilder(ExecutorSupplier executionSupplier) {
		this.executionSupplier = executionSupplier;

		ParameterListBuilder parameters = new ParameterListBuilder();
		executionSupplier.build(parameters);
		this.parameters = parameters.build();
	}


	@Override
	public List<String> getCompletion(ExecutionSpec specs) {
		return parameters.complete(specs);
	}

	@Override
	public boolean handleCommand(ExecutionSpec specs) {
		ParameterListBuilder parameters = new ParameterListBuilder();

		Executor execution = executionSupplier.build(parameters);
		ParameterList list = parameters.build();

		list.parse(specs);
		return execution.run(specs);
	}


	public interface ExecutorSupplier {
		Executor build(ParameterListBuilder params);
	}

	public interface Executor {

		boolean run(ExecutionSpec specs);

	}
}
