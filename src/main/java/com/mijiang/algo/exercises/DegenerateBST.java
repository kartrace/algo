package com.mijiang.algo.exercises;

import com.mijiang.algo.common.StdOut;
import com.mijiang.algo.search.BST;

public class DegenerateBST {
	
	public static void main(String[] args){
		BST<Integer, Integer> st = new BST<Integer, Integer>();
//		for (int i = 0; !StdIn.isEmpty(); i++) {
//			String key = StdIn.readString();
//			st.put(key, i);
//		}
		st.put(10, 10);
		st.put(8, 8);
		st.put(12, 12);
		st.put(5, 5);
		st.put(9, 9);
		st.put(11, 11);
		st.put(7, 7);
		st.put(6, 6);
		
		st.degenerate();

		for (Integer s : st.levelOrder())	
			StdOut.print(s + ", ");

		StdOut.println();

	}

}
