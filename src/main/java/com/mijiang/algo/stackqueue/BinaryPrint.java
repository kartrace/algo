package com.mijiang.algo.stackqueue;

public class BinaryPrint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max = ~0;
		printBinary(max);
	}
	
	private static void printBinary(int n){
		Stack<Integer> s = new Stack<Integer>();
		while (n != 0) {
		   s.push(n % 2);
		   n = n / 2;
		}
		while (!s.isEmpty())
		    System.out.print(s.pop());
		System.out.println();
	}

}
