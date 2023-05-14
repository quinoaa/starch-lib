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

import lombok.Setter;
import space.quinoaa.starch.command.ExecutionSpec;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WordParameter implements Parameter<String> {
	@Setter private Set<String> availableWords = null;
	private String word = null, raw = null;

	@Override
	public void parse(ExecutionSpec spec) {
		raw = spec.getArgumentList().consume();
		if(raw == null) return;
		if(availableWords != null && !availableWords.contains(raw)) return;

		word = raw;
	}

	@Override
	public boolean hasInput() {
		return word != null;
	}

	@Override
	public boolean isInputValid() {
		return hasInput();
	}

	@Override
	public String getInput() {
		return word;
	}

	@Override
	public List<String> getRawInput() {
		return raw != null ? Collections.singletonList(raw) : Collections.emptyList();
	}

	@Override
	public List<String> getComplete(ExecutionSpec spec) {
		String beg = spec.getArgumentList().consume();
		if(availableWords == null || beg == null) return Collections.emptyList();

		return availableWords.stream()
				.filter(word->word.startsWith(beg))
				.collect(Collectors.toList());
	}
}
