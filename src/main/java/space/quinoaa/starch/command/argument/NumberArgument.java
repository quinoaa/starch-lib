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

import org.jetbrains.annotations.Nullable;
import space.quinoaa.starch.command.Context;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumberArgument<T extends Number> extends SingleArgument {
	private final Function<String, T> parser;
	private final List<T> suggest;
	private T parsed;

	public NumberArgument(Function<String, T> parser, @Nullable List<T> suggest) {
		this.parser = parser;
		this.suggest = suggest;
	}


	@Override
	public List<String> getCompletion() {
		if(suggest == null) return Collections.emptyList();
		return suggest.stream()
				.map(Object::toString)
				.collect(Collectors.toList());
	}

	@Override
	protected void parse(Context context, @Nullable String argument) {
		parsed = null;
		if(argument == null) return;

		try{
			this.parsed = parser.apply(argument);
		}catch (NumberFormatException ignored) {}
	}

	public boolean isInputValid(){
		return parsed != null;
	}

	public @Nullable T getNumber(){
		return parsed;
	}



	public static class Int extends NumberArgument<Integer>{

		public Int(List<Integer> suggest) {
			super(Integer::parseInt, suggest);
		}

		public static Int any(){
			return new Int(null);
		}

		public static Int any(List<Integer> suggest){
			return new Int(suggest);
		}

	}


	public static class Double extends NumberArgument<java.lang.Double>{

		public Double(List<java.lang.Double> suggest) {
			super(java.lang.Double::parseDouble, suggest);
		}

		public static Double any(){
			return new Double(null);
		}

		public static Double any(List<java.lang.Double> suggest){
			return new Double(suggest);
		}

	}

	public static class Float extends NumberArgument<java.lang.Float>{

		public Float(List<java.lang.Float> suggest) {
			super(java.lang.Float::parseFloat, suggest);
		}

		public static Float any(){
			return new Float(null);
		}

		public static Float any(List<java.lang.Float> suggest){
			return new Float(suggest);
		}

	}

	public static class Long extends NumberArgument<java.lang.Long>{

		public Long(List<java.lang.Long> suggest) {
			super(java.lang.Long::parseLong, suggest);
		}

		public static Long any(){
			return new Long(null);
		}

		public static Long any(List<java.lang.Long> suggest){
			return new Long(suggest);
		}

	}

	public static class Short extends NumberArgument<java.lang.Short>{

		public Short(List<java.lang.Short> suggest) {
			super(java.lang.Short::parseShort, suggest);
		}

		public static Short any(){
			return new Short(null);
		}

		public static Short any(List<java.lang.Short> suggest){
			return new Short(suggest);
		}

	}

	public static class Byte extends NumberArgument<java.lang.Byte>{

		public Byte(List<java.lang.Byte> suggest) {
			super(java.lang.Byte::parseByte, suggest);
		}

		public static Byte any(){
			return new Byte(null);
		}

		public static Byte any(List<java.lang.Byte> suggest){
			return new Byte(suggest);
		}

	}

}
