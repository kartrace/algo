package com.mijiang.algo.graph;

public class GraphClient {
	
	public static int numOfSelfLoops(Graph g){
		int count = 0;
		for (int v = 0; v < g.V(); v++){
			for (int w: g.adj(v)){
				if(v == w) count++;
			}
		}
		return count/2;
	}

}
