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

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import space.quinoaa.starch.command.ExecutionSpec;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ParseParameter<T> implements Parameter<T> {
	private final Function<String, T> parser;
	@Setter private Set<T> available = null;

	private String raw = null;
	private T parsed = null;


	@Override
	public void parse(ExecutionSpec spec) {
		raw = spec.getArgumentList().consume();
		if(raw == null) return;

		try{
			T parsed = parser.apply(raw);
			if(!available.contains(parsed)) return;

			this.parsed = parsed;
		}catch (RuntimeException ignored){ }
	}

	@Override
	public boolean hasInput() {
		return raw != null;
	}

	@Override
	public boolean isInputValid() {
		return parsed != null;
	}

	@Override
	public T getInput() {
		return parsed;
	}

	@Override
	public List<String> getRawInput() {
		return raw != null ? Collections.singletonList(raw) : Collections.emptyList();
	}

	@Override
	public List<String> getComplete(ExecutionSpec spec) {
		String arg = spec.getArgumentList().consume();
		if(arg == null) return Collections.emptyList();
		if(available == null) return Collections.emptyList();

		return available.stream()
				.map(T::toString)
				.filter(available->available.startsWith(arg))
				.collect(Collectors.toList());
	}

	public static class Int extends ParseParameter<Integer>{

		public Int() {
			super(Integer::parseInt);
		}
	}

	public static class Double extends ParseParameter<java.lang.Double>{

		public Double() {
			super(java.lang.Double::parseDouble);
		}
	}

	public static class Long extends ParseParameter<java.lang.Long>{

		public Long() {
			super(java.lang.Long::parseLong);
		}
	}

}
