package com.mijiang.algo.sort;

import java.util.Comparator;

import com.mijiang.algo.common.StdOut;

public class SortHelper {

	private SortHelper() {
	}

	// is v < w ?
	public static boolean less(Comparable v, Comparable w) {
		return (v.compareTo(w) < 0);
	}

	// is v < w ?
	public static boolean less(Comparator c, Object v, Object w) {
		return (c.compare(v, w) < 0);
	}
	
	// does v == w ?
    public static boolean eq(Comparable v, Comparable w) {
        return (v.compareTo(w) == 0);
    }

	// exchange a[i] and a[j]
	public static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	// exchange a[i] and a[j] (for indirect sort)
	public static void exch(int[] a, int i, int j) {
		int swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	/***********************************************************************
	 * Check if array is sorted - useful for debugging
	 ***********************************************************************/
	public static boolean isSorted(Comparable[] a) {
		return isSorted(a, 0, a.length - 1);
	}

	// is the array sorted from a[lo] to a[hi]
	public static boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}

	public static boolean isSorted(Object[] a, Comparator c) {
		return isSorted(a, c, 0, a.length - 1);
	}

	// is the array sorted from a[lo] to a[hi]
	public static boolean isSorted(Object[] a, Comparator c, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++)
			if (less(c, a[i], a[i - 1]))
				return false;
		return true;
	}

	// print array to standard output
	public static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			StdOut.println(a[i]);
		}
	}

}
