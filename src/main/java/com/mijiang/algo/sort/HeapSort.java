package com.mijiang.algo.sort;

import static com.mijiang.algo.sort.SortHelper.*;

public class HeapSort {
	
	public static <E extends Comparable<?>> void sort(E[] a){
		int N = a.length;
		for (int k = N/2; k >= 1; k--)
			sink(a, k, N);
		while (N > 1){
			exch(a, 1, N--);
			sink(a, 1, N);
		}
	}

	
	private static void sink(Comparable[] a, int k, int N) {
		while (2 * k <= N){
			int j = 2 * k;
			if (j < N && less(a[j], a[j + 1])) j++;
			if (less(a[j], a[k])) break;
			exch(a, k, j);
			k = j;
		}
	}

}
