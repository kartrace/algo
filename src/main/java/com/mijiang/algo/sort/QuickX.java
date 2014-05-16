package com.mijiang.algo.sort;

import static com.mijiang.algo.sort.SortHelper.*;

import com.mijiang.algo.common.StdRandom;

public class QuickX {
	
	private static final int CUT_OFF = 8;
	
	public static void sort(Comparable[] a){
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		int N = hi - lo + 1;
		if (N <= CUT_OFF){
			Insertion.sort(a, lo, hi);
			return;
		}
		
		else if (N <= 40) {
            int m = median3(a, lo, lo + N/2, hi);
            exch(a, m, lo);
        }
		
		// use Tukey ninther as partitioning element
        else  {
            int eps = N/8;
            int mid = lo + N/2;
            int m1 = median3(a, lo, lo + eps, lo + eps + eps);
            int m2 = median3(a, mid - eps, mid, mid + eps);
            int m3 = median3(a, hi - eps - eps, hi - eps, hi); 
            int ninther = median3(a, m1, m2, m3);
            exch(a, ninther, lo);
        }
		
		//Bentley-McIlroy 3-way partitioning
		int i = lo, j = hi+1;
        int p = lo, q = hi+1;
        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v))
                if (i == hi) break;
            while (less(v, a[--j]))
                if (j == lo) break;
            if (i >= j) break;
            exch(a, i, j);
            if (eq(a[i], v)) exch(a, ++p, i);
            if (eq(a[j], v)) exch(a, --q, j);
        }
        exch(a, lo, j);

        i = j + 1;
        j = j - 1;
        for (int k = lo+1; k <= p; k++) exch(a, k, j--);
        for (int k = hi  ; k >= q; k--) exch(a, k, i++);
		
		
		sort(a, lo, j);
		sort(a, i, hi);
	}
	
	private static int median3(Comparable[] a, int i, int j, int k) {
        return (less(a[i], a[j]) ?
               (less(a[j], a[k]) ? j : less(a[i], a[k]) ? k : i) :
               (less(a[k], a[j]) ? j : less(a[k], a[i]) ? k : i));
    }


}
