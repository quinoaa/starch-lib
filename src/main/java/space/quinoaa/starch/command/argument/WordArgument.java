/*
 * MIT License
 *
 * Copyright (c) 2023 quinoaa
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
 *
 */

package space.quinoaa.starch.command.argument;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import space.quinoaa.starch.command.Context;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class WordArgument extends SingleArgument {
	private final Predicate<String> check;
	private final Set<String> completion;
	private String value;

	public WordArgument(@NotNull Predicate<String> check, @Nullable Set<String> completion) {
		this.check = check;
		this.completion = completion;
	}


	@Override
	public List<String> getCompletion() {
		if(completion == null) return Collections.emptyList();

		return new ArrayList<>(completion);
	}

	@Override
	protected void parse(Context context, @Nullable String argument) {
		value = null;
		if(argument == null) return;
		if(!check.test(argument)) return;

		value = argument;
	}


	public String getWord(){
		return value;
	}

	public boolean isWordValid(){
		return value != null;
	}


	public static WordArgument any(){
		return new WordArgument(str->true, null);
	}

	public static WordArgument any(Set<String> suggest){
		return new WordArgument(str->true, suggest);
	}

	public static WordArgument filtered(Predicate<String> filter){
		return new WordArgument(filter, null);
	}

	public static WordArgument filtered(Set<String> suggest, Predicate<String> filter){
		return new WordArgument(filter, suggest);
	}

	public static WordArgument ofSet(Set<String> choices){
		return new WordArgument(choices::contains, choices);
	}

}




