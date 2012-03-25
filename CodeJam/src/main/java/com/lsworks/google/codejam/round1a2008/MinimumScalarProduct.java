package com.lsworks.google.codejam.round1a2008;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

public class MinimumScalarProduct {

	public static void main(String[] args) throws IOException {
		MinimumScalarProduct product = new MinimumScalarProduct();
		product.calc();
	}

	private void calc() throws IOException {
		// File inputFile = new File(
		// "src/main/resources/round1a2008/minimum_scala_product-sample.txt");
		File inputFile = new File(
				"src/main/resources/round1a2008/A-small-practice.in");
		// File inputFile = new
		// File("src/main/resources/round1a2008/A-large-practice.in");
		List<String> inputs = Files.readLines(inputFile, Charsets.UTF_8);

		for (int test = 1; test <= Integer.parseInt(inputs.get(0)); test++) {
			List<Integer> n1 = Lists.newArrayList();
			for (String inputStr : inputs.get(test * 3 - 1).split(" "))
				n1.add(Integer.parseInt(inputStr));

			List<Integer> n2 = Lists.newArrayList();
			for (String inputStr : inputs.get(test * 3).split(" "))
				n2.add(Integer.parseInt(inputStr));

			BigInteger min = new BigInteger("0");
			while (!n1.isEmpty()) {
				Integer minN1 = Collections.min(n1);
				Integer maxN2 = Collections.max(n2);
				BigInteger biMinN1 = new BigInteger(minN1.toString());
				BigInteger biMaxN2 = new BigInteger(maxN2.toString());

				min = min.add(biMinN1.multiply(biMaxN2));

				n1.remove(minN1);
				n2.remove(maxN2);
			}

			System.out.format("Case #%d: ", test);
			System.out.println(min);
		}
	}
}
