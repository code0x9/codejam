package com.lsworks.google.codejam.round1c2012;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class DiamondInheritance {

	public static void main(String[] args) throws IOException {
		DiamondInheritance sin = new DiamondInheritance();
		sin.safe();
	}

	private void safe() throws IOException {
//		File inputFile = new File(
//				"src/main/resources/round1c2012/diamond-sample.txt");
						File inputFile = new File("C:/Users/ls/Downloads/A-small-attempt3.in");
		List<String> inputs = Files.readLines(inputFile, Charsets.UTF_8);
		int totalTest = Integer.parseInt(inputs.remove(0));

		for (int test = 1; test <= totalTest; test++) {
			int totalClass = Integer.parseInt(inputs.remove(0));

			Map<Integer, List<Integer>> klasses = new HashMap<Integer, List<Integer>>();
			for (int klass = 1; klass <= totalClass; klass++) {
				String[] inStr = inputs.remove(0).split(" ");
				int inheritsCount = Integer.parseInt(inStr[0]);

				List<Integer> klassParents = new ArrayList<Integer>();
				for (int inherits = 1; inherits <= inheritsCount; inherits++) {
					klassParents.add(Integer.parseInt(inStr[inherits]));
				}
				klasses.put(klass, klassParents);
			}

			boolean isDiamond = false;
			Map<Integer, Integer> backlinks = new HashMap<Integer, Integer>();
			for (int klass : klasses.keySet()) {
				List<Integer> klassParents = klasses.get(klass);
				for (int klassParent : klassParents) {
					if (backlinks.containsKey(klassParent) == false) {
						backlinks.put(klassParent, klass);
					} else {
						isDiamond = true;
						break;
					}
				}
			}

			System.out.format("Case #%d: %s\n", test, isDiamond ? "Yes" : "No");
		}
	}
}
