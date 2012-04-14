package com.lsworks.google.codejam.qualification2012;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class RecyclingNumbers {
	Set<Integer> output;

	public static void main(String[] args) throws IOException {
		RecyclingNumbers text2googleresse = new RecyclingNumbers();
		text2googleresse.t2g();
	}

	private void t2g() throws IOException {
		File inputFile = new File(
				"src/main/resources/qualification2012/C-sample.in");
		// File inputFile = new File(
		// "src/main/resources/qualification2012/B-small-attempt2.in");
		// File inputFile = new File(
		// "src/main/resources/qualification2012/A-large-practice.in");
		List<String> inputs = Files.readLines(inputFile, Charsets.UTF_8);
		int totalTest = Integer.parseInt(inputs.remove(0));

		for (int test = 1; test <= totalTest; test++) {
			String[] inStr = inputs.remove(0).split(" ");
			String a = inStr[0];
			String b = inStr[1];

			output = new HashSet<Integer>();
			// make(a, b);
			// System.out.println();
			// make(b, a);
			make2(a + b);
			System.out.println();
			System.out.println(output);
			// System.out.format("Case #%d: %s\n", test, output);
		}
	}

	private void make2(String str) {
		for (int len = 1; len < str.length(); len++) {
			for (int i = 0; i < str.length(); i++) {
				for (int j = len; j < str.length(); j++) {
					String prefix = str.substring(i);

					if (prefix.length() > len)
						prefix = prefix.substring(0, len);

					String suffix = str.substring(j);

					String out = prefix + suffix;
					if (out.length() > str.length() / 2)
						out = out.substring(0, str.length() / 2);

					System.out.print(out + ", ");

					int r = Integer.parseInt(out);
					int aInt = Integer.parseInt(str.substring(0,
							str.length() / 2));
					int bInt = Integer
							.parseInt(str.substring(str.length() / 2));
					if (aInt < bInt) {
						if (r >= aInt && r <= bInt) {
							output.add(r);
						}
					} else {
						if (r >= bInt && r <= aInt) {
							output.add(r);
						}
					}
				}
			}
		}
	}
}
