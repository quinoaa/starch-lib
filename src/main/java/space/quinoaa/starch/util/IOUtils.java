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

package space.quinoaa.starch.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class IOUtils {
	private static final int BUFFER_SIZE = 4096;

	public static byte[] readAllBytes(InputStream is) throws IOException {
		List<byte[]> buffers = new ArrayList<>();

		while(true){
			byte[] buffer = new byte[BUFFER_SIZE];

			int currentLength = 0;
			while(currentLength != BUFFER_SIZE){
				int read = is.read(buffer, currentLength, buffer.length - currentLength);

				if(read == -1){
					byte[] assembly = new byte[buffers.size() * BUFFER_SIZE + currentLength];

					for (int i = 0; i < buffers.size(); i++)
						System.arraycopy(buffers.get(i), 0, assembly, BUFFER_SIZE * i, BUFFER_SIZE);
					System.arraycopy(buffer, 0, assembly, BUFFER_SIZE * buffers.size(), currentLength);
					return assembly;
				}

				currentLength += read;
			}

			buffers.add(buffer);
		}
	}


}



