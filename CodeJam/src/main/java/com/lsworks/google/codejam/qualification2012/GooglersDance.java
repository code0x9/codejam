package com.lsworks.google.codejam.qualification2012;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class GooglersDance {

	public static void main(String[] args) throws IOException {
		GooglersDance text2googleresse = new GooglersDance();
		text2googleresse.t2g();
	}

	private void t2g() throws IOException {
		// File inputFile = new File(
		// "src/main/resources/qualification2012/B-sample.in");
//		File inputFile = new File(
//				"src/main/resources/qualification2012/B-small-attempt3.in");
		 File inputFile = new File(
		 "src/main/resources/qualification2012/B-large.in");
		List<String> inputs = Files.readLines(inputFile, Charsets.UTF_8);
		int totalTest = Integer.parseInt(inputs.remove(0));

		for (int test = 1; test <= totalTest; test++) {
			String[] inStr = inputs.remove(0).split(" ");
			int S = Integer.parseInt(inStr[1]);
			int p = Integer.parseInt(inStr[2]);

			int nm = 0;
			int sm = 0;
			
			if (p == 0) {
				nm = 0;
				sm = 0;
			} else if (p == 1) {
				nm = 1;
				sm = 1;
			} else if (p == 2) {
				nm = 4;
				sm = 2;
			} else {
				nm = 3 * (p - 1) + 1;
				sm = 3 * (p - 2) + 2;
			}

			int output = 0;
			for (int i = 3; i < inStr.length; i++) {
				int t = Integer.parseInt(inStr[i]);

				if (t >= nm) {
					output++;
				} else if (t >= sm && S > 0) {
					output++;
					S--;
				}
			}
			System.out.format("Case #%d: %s\n", test, output);
		}
	}
}
