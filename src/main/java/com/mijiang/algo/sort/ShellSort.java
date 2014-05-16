package com.mijiang.algo.sort;

import static com.mijiang.algo.sort.SortHelper.*;

public class ShellSort {
	
	private ShellSort(){};
	
	public static void sort(Comparable[] a){
		int length = a.length;
		int h = 1;
		while (h < length / 3) h = h * 3 + 1;
		while (h >= 1){
			for (int i = h; i < length; i++){
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h){
					exch(a, j, j-h);
				}
			}
			h = h / 3;
		}
	}

}
