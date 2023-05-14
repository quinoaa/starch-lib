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

import lombok.RequiredArgsConstructor;
import space.quinoaa.starch.command.ArgumentList;
import space.quinoaa.starch.command.ExecutionSpec;
import space.quinoaa.starch.command.executor.parameter.Parameter;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class ParameterList {
	private final List<Parameter<?>> parameters;

	public void parse(ExecutionSpec specs){
		parameters.forEach(param->param.parse(specs));
	}

	public List<String> complete(ExecutionSpec specs){
		List<String> complete = Collections.emptyList();
		ArgumentList args = specs.getArgumentList();

		for (Parameter<?> param : parameters) {
			if(!args.hasNext()) break;

			complete = param.getComplete(specs);
		}
		if(args.hasNext()) complete = Collections.emptyList();

		return complete;
	}

}
