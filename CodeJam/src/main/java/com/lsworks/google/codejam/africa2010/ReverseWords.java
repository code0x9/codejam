package com.lsworks.google.codejam.africa2010;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class ReverseWords {
	public static void main(String[] args) throws IOException {
//		File inputFile = new File("src/main/resources/reversewords-sample.txt");
		 File inputFile = new File("src/main/resources/B-large-practice.in");
//		 File inputFile = new File("src/main/resources/B-small-practice.in");
		List<String> inputs = Files.readLines(inputFile, Charsets.UTF_8);

		for (int test = 1; test <= Integer.parseInt(inputs.get(0)); test++) {
			String[] inputStr = inputs.get(test).split(" ");
			StringBuilder outputSb = new StringBuilder();
			for (int i = inputStr.length - 1; i >= 0; i--) {
				outputSb.append(inputStr[i]);
				outputSb.append(" ");
			}

			System.out.format("Case #%d: %s\n", test, outputSb);
		}
	}
}
