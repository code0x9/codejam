package com.lsworks.google.codejam.africa2010;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

public class StoreCredit {
	public static void main(String[] args) throws IOException {
		// File inputFile = new File("src/main/resources/africa2010/sample.txt");
		File inputFile = new File("src/main/resources/africa2010/A-large-practice.in");
		// File inputFile = new File("src/main/resources/africa2010/A-small-practice.in");
		List<String> inputs = Files.readLines(inputFile, Charsets.UTF_8);

		for (int test = 1; test <= Integer.parseInt(inputs.get(0)); test++) {
			int credit = Integer.parseInt(inputs.get(test * 3 - 2));
			List<Integer> prices = Lists.newArrayList();
			for (String inputStr : inputs.get(test * 3).split(" "))
				prices.add(Integer.parseInt(inputStr));

			int resA = -1, resB = -1, priceAIdx = 0;
			while (resA < 0 && resB < 0) {
				int priceA = prices.get(priceAIdx);
				int priceBIdx = priceAIdx + 1;
				while (priceBIdx < prices.size()) {
					int priceB = prices.get(priceBIdx);
					if (priceA + priceB == credit) {
						resA = priceAIdx + 1;
						resB = priceBIdx + 1;
						break;
					}
					priceBIdx++;
				}
				priceAIdx++;
			}

			System.out.format("Case #%d: %d %d\n", test, resA, resB);
		}
	}
}
