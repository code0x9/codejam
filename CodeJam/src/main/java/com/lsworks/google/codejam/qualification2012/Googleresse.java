package com.lsworks.google.codejam.qualification2012;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class Googleresse {

	Map<Character, Character> googleresseMap;

	public static void main(String[] args) throws IOException {
		Googleresse text2googleresse = new Googleresse();
		text2googleresse.t2g();
	}

	private void t2g() throws IOException {
		File sampleTxtFile = new File(
				"src/main/resources/qualification2012/A-sample.in");
		File sampleGrFile = new File(
				"src/main/resources/qualification2012/A-sample.out");
//		 File inputFile = new File(
//		 "src/main/resources/qualification2012/A-sample.in");
		 File inputFile = new File(
				 "src/main/resources/qualification2012/A-small-attempt0.in");
		// File inputFile = new File(
		// "src/main/resources/qualification2012/A-large-practice.in");
		List<String> inputs = Files.readLines(sampleTxtFile, Charsets.UTF_8);
		List<String> outputs = Files.readLines(sampleGrFile, Charsets.UTF_8);
		
		int totalTest = Integer.parseInt(inputs.remove(0));

		googleresseMap = new HashMap<Character, Character>();
		googleresseMap.put('a', 'y');
		googleresseMap.put('o', 'e');
		googleresseMap.put('z', 'q');
		googleresseMap.put('q', 'z');
		
		for (int test = 1; test <= totalTest; test++) {
			String inStr= inputs.remove(0);
			String outStr = outputs.remove(0);
			
			for (int i = 0; i < inStr.length(); i++) {
				googleresseMap.put(inStr.charAt(i), outStr.charAt(i));
			}
		}
		
		inputs = Files.readLines(inputFile, Charsets.UTF_8);
		totalTest = Integer.parseInt(inputs.remove(0));
		
		for (int test = 1; test <= totalTest; test++) {
			String inStr= inputs.remove(0);
			String result = "Case #" + test + ": ";
			for (int i = 0; i < inStr.length(); i++) {
				result += googleresseMap.get(inStr.charAt(i));
			}
			System.out.println(result);
		}
	}
}
