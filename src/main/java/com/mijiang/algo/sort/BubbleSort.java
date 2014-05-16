package com.mijiang.algo.sort;

import static com.mijiang.algo.sort.SortHelper.*;

public class BubbleSort {
	
	private BubbleSort(){}
	
	public static <E extends Comparable<?>> void sort(E[] a) {
		int N = a.length;
		boolean swapped = false;
		do {
			swapped = false;
			for (int i = 1; i < N; i++){
				if (less(a[i], a[i-1])){
					exch(a, i, i-1);
					swapped = true;
				}
			}
			N--;
		}while (swapped);
	}

	public static boolean less(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);
	}
}
