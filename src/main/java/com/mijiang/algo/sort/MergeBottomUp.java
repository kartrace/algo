package com.mijiang.algo.sort;

import static com.mijiang.algo.sort.SortHelper.*;

public class MergeBottomUp {
	
	private static Comparable[] aux;
	
	public static void sort(Comparable[] a){
		aux = new Comparable[a.length];
		int N = a.length;
		for (int sz = 1; sz < N; sz += sz){
			for (int lo = 0; lo < N - sz; lo += sz + sz){
				merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
			}
		}
	}
	
	private static void merge(Comparable[] a, int lo, int mid, int hi){
		int i = lo;
		int j = mid + 1;
		if (less(a[mid], a[mid + 1])) return;
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		for (int p = lo; p <= hi; p++){
			if (i > mid) a[p] = aux[j++];
			else if (j > hi) a[p] = aux[i++];
			else if (less(aux[i], aux[j])) a[p] = aux[i++];
			else a[p] = aux[j++];
		}
	}

}
