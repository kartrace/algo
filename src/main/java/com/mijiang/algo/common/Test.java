package com.mijiang.algo.common;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StdRandom.setSeed(9983);
		StdOut.println(StdRandom.uniform(250));
		StdOut.println(StdRandom.uniform(250));
		StdOut.println(StdRandom.uniform(250));
		StdOut.println(StdRandom.uniform(250));
		StdOut.println(StdRandom.uniform(250));
		
		StdRandom.setSeed(9983);
		StdOut.println(StdRandom.uniform(250));
		StdOut.println(StdRandom.uniform(250));
		StdOut.println(StdRandom.uniform(250));
		StdOut.println(StdRandom.uniform(250));
		StdOut.println(StdRandom.uniform(250));
		
		StdOut.print(Double.POSITIVE_INFINITY > (Double.POSITIVE_INFINITY + 1000000000000l));
		
		StdOut.println(0 % 2);
		
		int number = -8;
	     //right shifting bytes with sign 1 position
	     number = number>>>1;

	    StdOut.println(number);
	    
	    int[] a = new int[]{1,2,3};
	    update(a);
	    System.out.println(a[0]);

	}
	
	private static void update(int[] a){
		a[0] = -1;
		a = null;
	}
	
	


}
