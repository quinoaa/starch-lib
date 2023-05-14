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

import space.quinoaa.starch.command.executor.parameter.Parameter;
import space.quinoaa.starch.command.executor.parameter.ParseParameter;
import space.quinoaa.starch.command.executor.parameter.PlayerParameter;
import space.quinoaa.starch.command.executor.parameter.WordParameter;

import java.util.ArrayList;
import java.util.List;

public class ParameterListBuilder {
	private final List<Parameter<?>> parameters = new ArrayList<>();

	public <T extends Parameter<?>> T addParameter(T param) {
		parameters.add(param);
		return param;
	}



	public WordParameter addWord(){
		return addParameter(new WordParameter());
	}

	public PlayerParameter addPlayer(){
		return addParameter(new PlayerParameter());
	}

	public ParseParameter.Int addInt(){
		return addParameter(new ParseParameter.Int());
	}

	public ParseParameter.Long addLong(){
		return addParameter(new ParseParameter.Long());
	}

	public ParseParameter.Double addDouble(){
		return addParameter(new ParseParameter.Double());
	}



	public ParameterList build() {
		return new ParameterList(parameters);
	}

}
