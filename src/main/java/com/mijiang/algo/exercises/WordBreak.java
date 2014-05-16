package com.mijiang.algo.exercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	
	public static void main(String[] args){
		String str = "Iamasoftwareengineer";
		Set<String> dict = new HashSet<String>();
		dict.add("I");
		dict.add("am");
		dict.add("a");
		dict.add("software");
		dict.add("engineer");
		dict.add("ama");
		dict.add("soft");
		dict.add("wareengin");
		dict.add("eer");
		
		List<String> solutions = wordBreak(str, dict);
		for (String sol: solutions)
			System.out.println(sol);
	}

	private static List<String> wordBreak(String str, Set<String> dict) {
		List<String> sol = new ArrayList<String>();
		wordBreak(str, dict, 0, new StringBuffer(), sol);
		return sol;
	}

	private static void wordBreak(String str, Set<String> dict,
			int startIndex, StringBuffer sb, List<String> sol) {
		if (str == null || str.isEmpty()) return;
		if (startIndex >= str.length()) sol.add(sb.toString());
		for (int i = startIndex; i < str.length(); i++){
			String sub = str.substring(startIndex, i + 1);
			if (dict.contains(sub)){
				StringBuffer newSb = new StringBuffer(sb);
				newSb.append(sub);
				newSb.append(" ");
				wordBreak(str, dict, i + 1, newSb, sol);
			}
		}
	}

}
