package com.lsworks.google.codejam.round1c2012;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class ToyBoxFactory {
	private int maxTotal = 0;

	public class KV {
		public Integer key;
		public Integer value;

		public KV(Integer key, Integer value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return "KV [key=" + key + ", value=" + value + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		ToyBoxFactory sin = new ToyBoxFactory();
		sin.safe();
	}

	private void safe() throws IOException {
		File inputFile = new File(
				"src/main/resources/round1c2012/toyboxfactory-sample.txt");
		//				File inputFile = new File("C:/Users/ls/Downloads/A-small-attempt2.in");
		List<String> inputs = Files.readLines(inputFile, Charsets.UTF_8);
		int totalTest = Integer.parseInt(inputs.remove(0));

		for (int test = 1; test <= totalTest; test++) {
			maxTotal = 0;
			String[] totalBoxAndToy = inputs.remove(0).split(" ");
			int totalBox = Integer.parseInt(totalBoxAndToy[0]);
			int totalToy = Integer.parseInt(totalBoxAndToy[1]);

			List<KV> boxes = new ArrayList<KV>();
			String[] boxesStr = inputs.remove(0).split(" ");
			for (int boxCnt = 0; boxCnt < totalBox * 2; boxCnt += 2) {
				KV box = new KV(Integer.parseInt(boxesStr[boxCnt + 1]),
						Integer.parseInt(boxesStr[boxCnt]));
				boxes.add(box);
			}

			List<KV> toys = new ArrayList<KV>();
			String[] toysStr = inputs.remove(0).split(" ");
			for (int toyCnt = 0; toyCnt < totalToy * 2; toyCnt += 2) {
				KV toy = new KV(Integer.parseInt(toysStr[toyCnt + 1]),
						Integer.parseInt(toysStr[toyCnt]));
				toys.add(toy);
			}

			deplete(boxes, toys, 0);
			System.out.println(maxTotal);
			/*
			List<Map<Integer, Integer>> toys =new ArrayList<Map<Integer,Integer>>();
			
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
			*/
		}
	}

	private void deplete(List<KV> boxes, List<KV> toys, int total) {
		if (boxes.size() <= 0 || toys.size() <= 0) {
			return;
		} else {
			KV box = boxes.get(0);
			KV toy = toys.get(0);

			if (box.key.equals(toy.key)) {
				// assemble box and toy
				int min = Math.min(box.value, toy.value);
				total += min;
				if (maxTotal < total) {
					maxTotal = total;
				}

				if (min == box.value && min == toy.value) {
					deplete(boxes.subList(1, boxes.size()),
							toys.subList(1, toys.size()), total);
				} else if (min == box.value) {
					deplete(boxes.subList(1, boxes.size()), toys, total);
				} else if (min == toy.value) {
					deplete(boxes, toys.subList(1, toys.size()), total);
				}
			} else {
				// throw out box
				deplete(boxes.subList(1, boxes.size()), toys, total);

				// throw out toy
				deplete(boxes, toys.subList(1, toys.size()), total);
			}
		}
	}
}
