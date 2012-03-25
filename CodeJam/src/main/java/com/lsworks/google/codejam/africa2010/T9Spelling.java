package com.lsworks.google.codejam.africa2010;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class T9Spelling {
	public static void main(String[] args) throws IOException {
//		File inputFile = new File("src/main/resources/africa2010/spelling-sample.txt");
		 File inputFile = new File("src/main/resources/africa2010/C-large-practice.in");
//		 File inputFile = new File("src/main/resources/africa2010/C-small-practice.in");
		List<String> inputs = Files.readLines(inputFile, Charsets.UTF_8);
		// inputs = Lists.newArrayList("1", "abb");
		for (int test = 1; test <= Integer.parseInt(inputs.get(0)); test++) {
			String inputStr = inputs.get(test);
			String output = convert(inputStr);
			System.out.format("Case #%d: %s\n", test, output);
		}
	}

	private static String convert(String inputStr) {
		StringBuilder outputSb = new StringBuilder();
		char prevKey = '!';
		for (char inputChar : inputStr.toCharArray()) {
			if (outputSb.length() > 0) {
				prevKey = outputSb.charAt(outputSb.length() - 1);
			}

			if (inputChar == ' ') {
				outputSb.append(appendMulti("0", 1, prevKey));
			} else if (inputChar <= 'c') {
				outputSb.append(appendMulti("2", 3 - ('c' - inputChar), prevKey));
			} else if (inputChar <= 'f') {
				outputSb.append(appendMulti("3", 3 - ('f' - inputChar), prevKey));
			} else if (inputChar <= 'i') {
				outputSb.append(appendMulti("4", 3 - ('i' - inputChar), prevKey));
			} else if (inputChar <= 'l') {
				outputSb.append(appendMulti("5", 3 - ('l' - inputChar), prevKey));
			} else if (inputChar <= 'o') {
				outputSb.append(appendMulti("6", 3 - ('o' - inputChar), prevKey));
			} else if (inputChar <= 's') {
				outputSb.append(appendMulti("7", 4 - ('s' - inputChar), prevKey));
			} else if (inputChar <= 'v') {
				outputSb.append(appendMulti("8", 3 - ('v' - inputChar), prevKey));
			} else if (inputChar <= 'z') {
				outputSb.append(appendMulti("9", 4 - ('z' - inputChar), prevKey));
			}
		}
		return outputSb.toString();
	}

	private static String appendMulti(String appendChar, int times, char prevKey) {
		StringBuilder outputSb = new StringBuilder();

		if (appendChar.charAt(0) == prevKey)
			outputSb.append(" ");
		
		for (int i = 0; i < times; i++) {
			outputSb.append(appendChar);
		}
		return outputSb.toString();
	}
}
