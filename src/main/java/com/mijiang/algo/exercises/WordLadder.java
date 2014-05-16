package com.mijiang.algo.exercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
	
	public static void main(String[] args){
		String src = "hit";
		String end = "cog";
		
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		dict.add("cog");
		
		List<String> path = wordLadder(src, end, dict);
		for (String p: path)
			System.out.println(p);
	}

	private static List<String> wordLadder(String src, String end,
			Set<String> dict) {
		List<String> sol = new ArrayList<String>();
		wordLadder(src, end, dict, new StringBuffer(src + "->"), sol);
		return sol;
	}

	private static void wordLadder(String src, String end, Set<String> dict,
			StringBuffer sb, List<String> sol) {
		//System.out.println(sb);
		if (src == null || end == null || src.isEmpty() || end.isEmpty()) return;
		if (src.equals(end)) sol.add(sb.toString());
		for(int i = 0; i < src.length(); i++){
			char[] chars = src.toCharArray();
			for (char c = 'a'; c <= 'z'; c++){
				if (chars[i] == c) continue;
				chars[i] = c;
				String s = new String(chars);
				if (!dict.contains(s)) continue;
				StringBuffer newSb = new StringBuffer(sb);
				newSb.append(s);
				newSb.append("->");
				dict.remove(s);
				wordLadder(s, end, dict, newSb, sol);
				dict.add(s);
			}
			
		}
	}

}
