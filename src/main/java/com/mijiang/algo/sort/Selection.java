package com.mijiang.algo.sort;

import java.util.Comparator;

import com.mijiang.algo.common.StdIn;
import com.mijiang.algo.common.StdOut;
import static com.mijiang.algo.sort.SortHelper.*;

/**
 * The <tt>Selection</tt> class provides static methods for sorting an array
 * using selection sort.
 * <p>
 * For additional documentation, see <a
 * href="http://algs4.cs.princeton.edu/21elementary">Section 2.1</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 * 
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class Selection {

	// This class should not be instantiated.
	private Selection() {
	}

	/**
	 * Rearranges the array in ascending order, using the natural order.
	 * 
	 * @param a
	 *            the array to be sorted
	 */
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (less(a[j], a[min]))
					min = j;
			}
			exch(a, i, min);
			assert isSorted(a, 0, i);
		}
		assert isSorted(a);
	}

	/**
	 * Rearranges the array in ascending order, using a comparator.
	 * 
	 * @param a
	 *            the array
	 * @param c
	 *            the comparator specifying the order
	 */
	public static void sort(Object[] a, Comparator c) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++) {
				if (less(c, a[j], a[min]))
					min = j;
			}
			exch(a, i, min);
			assert isSorted(a, c, 0, i);
		}
		assert isSorted(a, c);
	}

	/**
	 * Reads in a sequence of strings from standard input; selection sorts them;
	 * and prints them to standard output in ascending order.
	 */
	public static void main(String[] args) {
		String[] a = StdIn.readAllStrings();
		Selection.sort(a);
		show(a);
	}
}
