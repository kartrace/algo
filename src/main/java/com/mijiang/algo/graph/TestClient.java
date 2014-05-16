package com.mijiang.algo.graph;

import com.mijiang.algo.common.StdOut;

public class TestClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Graph g = new Graph(2);
		g.addEdge(0, 0);
		g.addEdge(0, 1);
		StdOut.println(GraphClient.numOfSelfLoops(g));
		
		StdOut.println(-1000 % 6);
		StdOut.println(17 << 1);
		StdOut.println(-17 >> 1);
		StdOut.println(17 >>> 1);
		StdOut.println(-17 >>> 1);
	}
	
	 

}
