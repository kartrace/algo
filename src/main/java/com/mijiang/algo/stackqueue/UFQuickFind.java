package com.mijiang.algo.stackqueue;

import com.mijiang.algo.common.FileOut;
import com.mijiang.algo.common.StdIn;
import com.mijiang.algo.common.StdOut;
import com.mijiang.algo.common.StdRandom;
import com.mijiang.algo.common.Stopwatch;

public class UFQuickFind {
	
	private int[] id;
	private int count;
	
	public UFQuickFind(int N){
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}
	
	public int count(){
		return count;
	}
	
	public int find(int n){
		if (n < 0 || n >= id.length)
			throw new IndexOutOfBoundsException();
		return id[n];
	}
	
	public boolean connected(int p, int q){
		return find(p) == find(q);
	}
	
	public void union(int p, int q){
		int pID = find(p);
		int qID = find(q);
		
		if (pID == qID) return;
		
		for (int i = 0; i < id.length; i++){
			if (id[i] == pID) id[i] = qID;
		}
		count--;
	}

	/**
     * Reads in a an integer <tt>N</tt> and a sequence of pairs of integers
     * (between <tt>0</tt> and <tt>N-1</tt>) from standard input, where each integer
     * in the pair represents some site;
     * if the sites are in different components, merge the two components
     * and print the pair to standard output.
     */
    public static void main(String[] args) {
    	for (int N = 250; N <= 10000000; N *= 1.25) {
            double time = quickFind(N);
            StdOut.printf("%7d %5.1f\n", N, time);
            FileOut.print(N);
            FileOut.print("\t");
            FileOut.println(time);
        } 
    }

	private static double quickFind(int n) {
		Stopwatch timer = new Stopwatch();
		UFQuickFind uf = new UFQuickFind(n);
        for (int i = 0; i < n; i++) {
            int p = StdRandom.uniform(n);
            int q = StdRandom.uniform(n);
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            //StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
        return timer.elapsedTime();
	}

}
