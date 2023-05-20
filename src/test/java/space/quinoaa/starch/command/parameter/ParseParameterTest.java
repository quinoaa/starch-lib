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


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import space.quinoaa.starch.command.ArgumentList;
import space.quinoaa.starch.command.ExecutionSpec;
import space.quinoaa.starch.command.executor.parameter.ParseParameter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ParseParameterTest {

	@Test
	public void testInt(){
		String[] args = {"123"};

		ExecutionSpec spec = new ExecutionSpec(null, null, null, new ArgumentList(args));
		ParseParameter.Int param = new ParseParameter.Int();

		param.parse(spec);
		Assertions.assertTrue(param.hasInput());
		Assertions.assertTrue(param.isInputValid());
		Assertions.assertEquals(123, param.getInput());
	}

	@Test
	public void testDouble(){
		String[] args = {"123.5"};

		ExecutionSpec spec = new ExecutionSpec(null, null, null, new ArgumentList(args));
		ParseParameter.Double param = new ParseParameter.Double();

		param.parse(spec);
		Assertions.assertTrue(param.hasInput());
		Assertions.assertTrue(param.isInputValid());
		Assertions.assertEquals(123.5, param.getInput());
	}

	@Test
	public void testLong(){
		String[] args = {"99123456789"};

		ExecutionSpec spec = new ExecutionSpec(null, null, null, new ArgumentList(args));
		ParseParameter.Long param = new ParseParameter.Long();

		param.parse(spec);
		Assertions.assertTrue(param.hasInput());
		Assertions.assertTrue(param.isInputValid());
		Assertions.assertEquals(99123456789L, param.getInput());
	}

	@Test
	public void testInvalid(){
		String[] args = {"123aa"};

		ExecutionSpec spec = new ExecutionSpec(null, null, null, new ArgumentList(args));
		ParseParameter.Int param = new ParseParameter.Int();

		param.parse(spec);
		Assertions.assertTrue(param.hasInput());
		Assertions.assertFalse(param.isInputValid());
		Assertions.assertNull(param.getInput());
	}

	@Test
	public void testComplete(){
		String[] args = {"12"};

		ExecutionSpec spec = new ExecutionSpec(null, null, null, new ArgumentList(args));
		ParseParameter.Int param = new ParseParameter.Int();

		Assertions.assertEquals(0, param.getComplete(spec).size());

		spec = new ExecutionSpec(null, null, null, new ArgumentList(args));
		param.setAvailable(new HashSet<>(Arrays.asList(123, 11, 1, 456, 1279)));

		List<String> result = param.getComplete(spec);
		Assertions.assertTrue(result.contains("123"));
		Assertions.assertTrue(result.contains("1279"));
		Assertions.assertFalse(result.contains("11"));
		Assertions.assertFalse(result.contains("1"));
		Assertions.assertFalse(result.contains("456"));
		Assertions.assertEquals(2, result.size());
	}


}
