package com.mijiang.algo.stackqueue;

import com.mijiang.algo.common.FileOut;
import com.mijiang.algo.common.StdOut;
import com.mijiang.algo.common.StdRandom;
import com.mijiang.algo.common.Stopwatch;

public class WeightedQuickUnion {
	
	private int[] id;
	private int count;
	private int[] sz;
	
	public WeightedQuickUnion(int N){
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
		sz = new int[N];
		for (int i = 0; i < N; i++)
			sz[i] = 1;
	}
	
	public int count(){
		return count;
	}
	
	public int find(int n){
		if (n < 0 || n >= id.length)
			throw new IndexOutOfBoundsException();
		while (n != id[n]) n = id[n];
		return n;
	}
	
	public boolean connected(int p, int q){
		return find(p) == find(q);
	}
	
	public void union(int p, int q){
		int pID = find(p);
		int qID = find(q);
		
		if (pID == qID) return;
		
		if (sz[pID] < sz[qID]) {
			id[pID] = qID;
			sz[qID] += sz[pID];
		}else{
			id[qID] = pID;
			sz[pID] += sz[qID];
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
    	for (int N = 250; N <= 100000000; N *= 1.25) {
            double time = weightedQuickUnion(N);
            StdOut.printf("%7d %5.1f\n", N, time);
            FileOut.print(N);
            FileOut.print("\t");
            FileOut.println(time);
        } 
    }

	private static double weightedQuickUnion(int n) {
		Stopwatch timer = new Stopwatch();
		WeightedQuickUnion uf = new WeightedQuickUnion(n);
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
