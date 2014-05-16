package com.mijiang.algo.sort;

import static com.mijiang.algo.sort.SortHelper.less;

public class MergeXSort {

	public static void sort(Comparable[] a) {
		Comparable[] aux = a.clone();
		sort(aux, a, 0, a.length - 1);
	}

	private static void sort(Comparable[] src, Comparable[] dest, int lo, int hi) {
//		if (hi <= lo) return;
		if (hi - lo < 15) {
			Insertion.sort(dest, lo, hi);
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(dest, src, lo, mid);
		sort(dest, src, mid + 1, hi);

		if (!less(src[mid + 1], src[mid])){
			System.arraycopy(src, lo, dest, lo, hi - lo + 1);
			return;
		}
		merge(src, dest, lo, mid, hi);
	}

	private static void merge(Comparable[] src, Comparable[] dest, int lo, int mid, int hi) {
		int i = lo;
		int j = mid + 1;
//		for (int k = lo; k <= hi; k++)
//			aux[k] = a[k];
		int pos = lo;
		while (pos <= hi) {
			if (i > mid)
				dest[pos++] = src[j++];
			else if (j > hi)
				dest[pos++] = src[i++];
			else if (less(src[i], src[j]))
				dest[pos++] = src[i++];
			else
				dest[pos++] = src[j++];
		}
	}

}
