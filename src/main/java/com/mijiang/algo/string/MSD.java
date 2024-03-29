package com.mijiang.algo.string;

import com.mijiang.algo.common.StdIn;
import com.mijiang.algo.common.StdOut;

public class MSD {
	private static final int R = 256; // extended ASCII alphabet size
	private static final int CUTOFF = 15; // cutoff to insertion sort

	// sort array of strings
	public static void sort(String[] a) {
		int N = a.length;
		String[] aux = new String[N];
		sort(a, 0, N - 1, 0, aux);
	}

	// return dth character of s, -1 if d = length of string
	private static int charAt(String s, int d) {
		assert d >= 0 && d <= s.length();
		if (d == s.length())
			return -1;
		return s.charAt(d);
	}

	// sort from a[lo] to a[hi], starting at the dth character
	private static void sort(String[] a, int lo, int hi, int d, String[] aux) {

		// cutoff to insertion sort for small subarrays
		if (hi <= lo + CUTOFF) {
			insertion(a, lo, hi, d);
			return;
		}

		// compute frequency counts
		int[] count = new int[R + 2];
		for (int i = lo; i <= hi; i++) {
			int c = charAt(a[i], d);
			count[c + 2]++;
		}

		// transform counts to indicies
		for (int r = 0; r < R + 1; r++)
			count[r + 1] += count[r];

		// distribute
		for (int i = lo; i <= hi; i++) {
			int c = charAt(a[i], d);
			aux[count[c + 1]++] = a[i];
		}

		// copy back
		for (int i = lo; i <= hi; i++)
			a[i] = aux[i - lo];

		// recursively sort for each character
		for (int r = 0; r < R; r++)
			sort(a, lo + count[r], lo + count[r + 1] - 1, d + 1, aux);
	}

	// return dth character of s, -1 if d = length of string
	private static void insertion(String[] a, int lo, int hi, int d) {
		for (int i = lo; i <= hi; i++)
			for (int j = i; j > lo && less(a[j], a[j - 1], d); j--)
				exch(a, j, j - 1);
	}

	// exchange a[i] and a[j]
	private static void exch(String[] a, int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// is v less than w, starting at character d
	// DEPRECATED BECAUSE OF SLOW SUBSTRING EXTRACTION IN JAVA 7
	// private static boolean less(String v, String w, int d) {
	// assert v.substring(0, d).equals(w.substring(0, d));
	// return v.substring(d).compareTo(w.substring(d)) < 0;
	// }

	// is v less than w, starting at character d
	private static boolean less(String v, String w, int d) {
		assert v.substring(0, d).equals(w.substring(0, d));
		for (int i = d; i < Math.min(v.length(), w.length()); i++) {
			if (v.charAt(i) < w.charAt(i))
				return true;
			if (v.charAt(i) > w.charAt(i))
				return false;
		}
		return v.length() < w.length();
	}

	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		int N = a.length;
		sort(a);
		for (int i = 0; i < N; i++)
			StdOut.println(a[i]);
	}
}
