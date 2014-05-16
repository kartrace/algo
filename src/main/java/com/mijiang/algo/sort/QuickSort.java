package com.mijiang.algo.sort;

import static com.mijiang.algo.sort.SortHelper.*;

import com.mijiang.algo.common.StdRandom;

public class QuickSort {
	
	public static void sort(Comparable[] a){
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (lo >= hi) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}
	
	private static int partition(Comparable[] a, int lo, int hi){
		Comparable val = a[lo];
		int i = lo;
		int j = hi + 1;
		while (true){
			while (less(a[++i], val)) if (i == hi) break;
			while (less(val, a[--j])) if (j == lo) break;
			if (i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}

}
