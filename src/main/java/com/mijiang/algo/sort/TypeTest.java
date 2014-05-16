package com.mijiang.algo.sort;

public class TypeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] str = new String[]{"1", "2", "3"};
		Object[] obj = str;
		obj[1] = 1;
		change(str);
	}
	
	public static void change(Object[] obj){
		obj[0] = 12;
	}

}
