package com.lsworks.google.codejam.round1b2012;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.Files;

public class SafetyInNumbers {

	public static void main(String[] args) throws IOException {
		SafetyInNumbers sin = new SafetyInNumbers();
		sin.safe();
	}

	private void safe() throws IOException {
//		File inputFile = new File(
//				"src/main/resources/round1b2012/safety-sample.txt");
		 File inputFile = new
		 File("C:/Users/ls/Downloads/A-small-practice (1).in");
		List<String> inputs = Files.readLines(inputFile, Charsets.UTF_8);

		int totalTest = Integer.parseInt(inputs.remove(0));

		for (int test = 1; test <= totalTest; test++) {
			String[] inStr = inputs.remove(0).split(" ");
			int contestant = Integer.parseInt(inStr[0]);
			List<Double> judgeScores = Lists.newArrayList();
			double judgeSum = 0;
			double nonZeroCnt = 0;
			double zeroCnt = 0;
			for (int i = 1; i <= contestant; i++) {
				double judgeScore = Integer.parseInt(inStr[i]);
				if (judgeScore == 0) {
					zeroCnt++;
				} else {
					judgeSum += judgeScore;
					nonZeroCnt++;
				}
				judgeScores.add(judgeScore);
			}

			System.out.format("Case #%d: ", test);
			double targetScore = 0;
			if (zeroCnt == 0) {
				targetScore = (judgeSum / nonZeroCnt) * 2;
			} else {
				targetScore = (judgeSum / nonZeroCnt) / zeroCnt;
			}

			for (int i = 1; i <= contestant; i++) {
				double judgeScore = judgeScores.get(i - 1);
				double x = (targetScore - judgeScore) / judgeSum;
				double out = Math.round(x * 1000000) / 10000.0;
				if (out < 0)
					out = 0;
				System.out.print(out + " ");
			}
			System.out.println();
		}
	}
}
