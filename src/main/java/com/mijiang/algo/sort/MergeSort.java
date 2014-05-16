package com.mijiang.algo.sort;

import static com.mijiang.algo.sort.SortHelper.*;

public class MergeSort {
	
	private static Comparable[] aux;
	
	public static void sort(Comparable[] a){
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);
		sort(a, mid+1, hi);
		merge(a, lo, mid, hi);
	}

	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		int pos = lo;	
		while (pos <= hi){
			if (i > mid) a[pos++] = aux[j++];
			else if (j > hi) a[pos++] = aux[i++];
			else if (less(aux[i], aux[j])) a[pos++] = aux[i++];
			else a[pos++] = aux[j++];
		}
	}

}
