package com.mijiang.algo.sort;

import static com.mijiang.algo.sort.SortHelper.eq;
import static com.mijiang.algo.sort.SortHelper.exch;
import static com.mijiang.algo.sort.SortHelper.less;

import com.mijiang.algo.common.StdOut;


public class QuickMid {

	private static final int CUT_OFF = 8;

	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		int N = hi - lo + 1;
		if (N <= CUT_OFF) {
			Insertion.sort(a, lo, hi);
			return;
		}

		else if (N <= 40) {
			int m = median3(a, lo, lo + N / 2, hi);
			exch(a, m, lo);
		}

		// use Tukey ninther as partitioning element
		else {
			int eps = N / 8;
			int mid = lo + N / 2;
			int m1 = median3(a, lo, lo + eps, lo + eps + eps);
			int m2 = median3(a, mid - eps, mid, mid + eps);
			int m3 = median3(a, hi - eps - eps, hi - eps, hi);
			int ninther = median3(a, m1, m2, m3);
			exch(a, ninther, lo);
		}

		// Mingwei 3-way partitioning
//		StdOut.println("initial values:");
//		print(a);
		int i = lo, j = hi;
		int p = lo + (hi - lo)/2;
		int q = lo + (hi - lo)/2 + 1;
//		StdOut.println("i=" + i + ", j=" + j + ", p=" + p + ", q=" + q);
		Comparable v = a[lo];
		while (true) {
			while (i <= p){
				int cmpLT = a[i].compareTo(v);
				if (cmpLT == 0){
					exch(a, p--, i);
//					print(a);
//					StdOut.println("i=" + i + ", j=" + j + ", p=" + p + ", q=" + q);
				}
				else if (cmpLT < 0){
					i++;
//					print(a);
//					StdOut.println("i=" + i + ", j=" + j + ", p=" + p + ", q=" + q);
				}
				else 
					break;
			}
			while (j >= q){
				int cmpGT = a[j].compareTo(v);
				if (cmpGT == 0){
					exch(a, q++, j);
//					print(a);
//					StdOut.println("i=" + i + ", j=" + j + ", p=" + p + ", q=" + q);
				}
				else if (cmpGT > 0){
					j--;
//					print(a);
//					StdOut.println("i=" + i + ", j=" + j + ", p=" + p + ", q=" + q);
				}
				else 
					break;
			}
			if (i > p && j < q)
				break;
			else if (i > p){
				exch(a, i++, j, q++);
//				print(a);
//				StdOut.println("i=" + i + ", j=" + j + ", p=" + p + ", q=" + q);
			}
			else if (j < q){
				exch(a, j--, i, p--);
//				print(a);
//				StdOut.println("i=" + i + ", j=" + j + ", p=" + p + ", q=" + q);
			}
			else{
				exch(a, i++, j--);
//				print(a);
//				StdOut.println("i=" + i + ", j=" + j + ", p=" + p + ", q=" + q);
			}
		}

		sort(a, lo, i - 1);
		sort(a, j + 1, hi);
	}
	
	private static void print(Object[] data) {
		StdOut.print("[");
		for (Object obj: data)
			StdOut.print(obj + ",");
		StdOut.println("]");
	}

	private static void exch(Comparable[] a, int i, int j, int q) {
		Comparable tmp = a[i];
		a[i] = a[j];
		a[j] = a[q];
		a[q] = tmp;
	}

	private static int median3(Comparable[] a, int i, int j, int k) {
		return (less(a[i], a[j]) ? (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k
				: i) : (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));
	}
	
	public static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

}
