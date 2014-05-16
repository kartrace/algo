package com.mijiang.algo.exercises;

public class LongestCommonString {

	public String lcs(String str1, String str2) {
		if (str1 == null || str2 == null || str1.isEmpty() || str2.isEmpty())
			return "";
		int n = str1.length();
		int m = str2.length();
		int[][] counts = new int[n][m];
		int maxCount = 0;
		int maxIndex = -1;
		for (int i = 0; i < n; i++) {
			char chari = str1.charAt(i);
			for (int j = 0; j < m; j++) {
				char charj = str2.charAt(j);
				int count = 0;
				if (chari == charj) {
					if (i == 0 || j == 0)
						count = 1; // base case
					else {
						count = 1 + counts[i - 1][j - 1];
					}
				}
				counts[i][j] = count;
				if (count > maxCount) {
					maxCount = count;
					maxIndex = j;
				}
			}
		}
		if (maxIndex == -1)
			return "";
		return str2.substring(maxIndex - maxCount + 1, maxIndex + 1);
	}
	
	public static void main(String[] args){
		LongestCommonString lcs = new LongestCommonString();
		String str1 = "riddick will win";
		String str2 = "iddick will lose";
		System.out.println(lcs.lcs(str1, str2));
	}

}
