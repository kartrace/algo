package com.mijiang.algo.graph.algo;

import com.mijiang.algo.common.StdOut;
import com.mijiang.algo.graph.DepthFirstOrder;
import com.mijiang.algo.graph.Digraph;
import com.mijiang.algo.graph.app.TransitiveClosure;
import com.mijiang.algo.stackqueue.In;
import com.mijiang.algo.stackqueue.Queue;

/**
 * The <tt>KosarajuSharirSCC</tt> class represents a data type for determining
 * the strong components in a digraph. The <em>id</em> operation determines in
 * which strong component a given vertex lies; the <em>areStronglyConnected</em>
 * operation determines whether two vertices are in the same strong component;
 * and the <em>count</em> operation determines the number of strong components.
 * 
 * The <em>component identifier</em> of a component is one of the vertices in
 * the strong component: two vertices have the same component identifier if and
 * only if they are in the same strong component.
 * 
 * <p>
 * This implementation uses the Kosaraju-Sharir algorithm. The constructor takes
 * time proportional to <em>V</em> + <em>E</em> (in the worst case), where
 * <em>V</em> is the number of vertices and <em>E</em> is the number of edges.
 * Afterwards, the <em>id</em>, <em>count</em>, and
 * <em>areStronglyConnected</em> operations take constant time. For alternate
 * implementations of the same API, see {@link TarjanSCC} and {@link GabowSCC}.
 * <p>
 * For additional documentation, see <a href="/algs4/42digraph">Section 4.2</a>
 * of <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 * 
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class KosarajuSharirSCC {
	private boolean[] marked; // marked[v] = has vertex v been visited?
	private int[] id; // id[v] = id of strong component containing v
	private int count; // number of strongly-connected components

	/**
	 * Computes the strong components of the digraph <tt>G</tt>.
	 * 
	 * @param G
	 *            the digraph
	 */
	public KosarajuSharirSCC(Digraph G) {

		// compute reverse postorder of reverse graph
		DepthFirstOrder dfs = new DepthFirstOrder(G.reverse());

		// run DFS on G, using reverse postorder to guide calculation
		marked = new boolean[G.V()];
		id = new int[G.V()];
		for (int v : dfs.reversePost()) {
			if (!marked[v]) {
				dfs(G, v);
				count++;
			}
		}

		// check that id[] gives strong components
		assert check(G);
	}

	// DFS on graph G
	private void dfs(Digraph G, int v) {
		marked[v] = true;
		id[v] = count;
		for (int w : G.adj(v)) {
			if (!marked[w])
				dfs(G, w);
		}
	}

	/**
	 * Returns the number of strong components.
	 * 
	 * @return the number of strong components
	 */
	public int count() {
		return count;
	}

	/**
	 * Are vertices <tt>v</tt> and <tt>w</tt> in the same strong component?
	 * 
	 * @param v
	 *            one vertex
	 * @param w
	 *            the other vertex
	 * @return <tt>true</tt> if vertices <tt>v</tt> and <tt>w</tt> are in the
	 *         same strong component, and <tt>false</tt> otherwise
	 */
	public boolean stronglyConnected(int v, int w) {
		return id[v] == id[w];
	}

	/**
	 * Returns the component id of the strong component containing vertex
	 * <tt>v</tt>.
	 * 
	 * @param v
	 *            the vertex
	 * @return the component id of the strong component containing vertex
	 *         <tt>v</tt>
	 */
	public int id(int v) {
		return id[v];
	}

	// does the id[] array contain the strongly connected components?
	private boolean check(Digraph G) {
		TransitiveClosure tc = new TransitiveClosure(G);
		for (int v = 0; v < G.V(); v++) {
			for (int w = 0; w < G.V(); w++) {
				if (stronglyConnected(v, w) != (tc.reachable(v, w) && tc
						.reachable(w, v)))
					return false;
			}
		}
		return true;
	}

	/**
	 * Unit tests the <tt>KosarajuSharirSCC</tt> data type.
	 */
	public static void main(String[] args) {
		In in = new In(args[0]);
		Digraph G = new Digraph(in);
		KosarajuSharirSCC scc = new KosarajuSharirSCC(G);

		// number of connected components
		int M = scc.count();
		StdOut.println(M + " components");

		// compute list of vertices in each strong component
		Queue<Integer>[] components = (Queue<Integer>[]) new Queue[M];
		for (int i = 0; i < M; i++) {
			components[i] = new Queue<Integer>();
		}
		for (int v = 0; v < G.V(); v++) {
			components[scc.id(v)].enqueue(v);
		}

		// print results
		for (int i = 0; i < M; i++) {
			for (int v : components[i]) {
				StdOut.print(v + " ");
			}
			StdOut.println();
		}

	}

}
