package com.mijiang.algo.graph;

import com.mijiang.algo.common.StdIn;
import com.mijiang.algo.common.StdOut;
import com.mijiang.algo.search.ST;
import com.mijiang.algo.stackqueue.In;

public class SymbolGraph {
	private ST<String, Integer> st; // string -> index
	private String[] keys; // index -> string
	private Graph G;

	/**
	 * Initializes a graph from a file using the specified delimiter. Each line
	 * in the file contains the name of a vertex, followed by a list of the
	 * names of the vertices adjacent to that vertex, separated by the
	 * delimiter.
	 * 
	 * @param filename
	 *            the name of the file
	 * @param delimiter
	 *            the delimiter between fields
	 */
	public SymbolGraph(String filename, String delimiter) {
		st = new ST<String, Integer>();

		// First pass builds the index by reading strings to associate
		// distinct strings with an index
		In in = new In(filename);
		// while (in.hasNextLine()) {
		while (!in.isEmpty()) {
			String[] a = in.readLine().split(delimiter);
			for (int i = 0; i < a.length; i++) {
				if (!st.contains(a[i]))
					st.put(a[i], st.size());
			}
		}
		StdOut.println("Done reading " + filename);

		// inverted index to get string keys in an aray
		keys = new String[st.size()];
		for (String name : st.keys()) {
			keys[st.get(name)] = name;
		}

		// second pass builds the graph by connecting first vertex on each
		// line to all others
		G = new Graph(st.size());
		in = new In(filename);
		while (in.hasNextLine()) {
			String[] a = in.readLine().split(delimiter);
			int v = st.get(a[0]);
			for (int i = 1; i < a.length; i++) {
				int w = st.get(a[i]);
				G.addEdge(v, w);
			}
		}
	}

	/**
	 * Does the graph contain the vertex named <tt>s</tt>?
	 * 
	 * @param s
	 *            the name of a vertex
	 * @return <tt>true</tt> if <tt>s</tt> is the name of a vertex, and
	 *         <tt>false</tt> otherwise
	 */
	public boolean contains(String s) {
		return st.contains(s);
	}

	/**
	 * Returns the integer associated with the vertex named <tt>s</tt>.
	 * 
	 * @param s
	 *            the name of a vertex
	 * @return the integer (between 0 and <em>V</em> - 1) associated with the
	 *         vertex named <tt>s</tt>
	 */
	public int index(String s) {
		return st.get(s);
	}

	/**
	 * Returns the name of the vertex associated with the integer <tt>v</tt>.
	 * 
	 * @param v
	 *            the integer corresponding to a vertex (between 0 and
	 *            <em>V</em> - 1)
	 * @return the name of the vertex associated with the integer <tt>v</tt>
	 */
	public String name(int v) {
		return keys[v];
	}

	/**
	 * Returns the graph assoicated with the symbol graph. It is the client's
	 * responsibility not to mutate the graph.
	 * 
	 * @return the graph associated with the symbol graph
	 */
	public Graph G() {
		return G;
	}

	/**
	 * Unit tests the <tt>SymbolGraph</tt> data type.
	 */
	public static void main(String[] args) {
		String filename = args[0];
		String delimiter = args[1];
		SymbolGraph sg = new SymbolGraph(filename, delimiter);
		Graph G = sg.G();
		while (StdIn.hasNextLine()) {
			String source = StdIn.readLine();
			if (sg.contains(source)) {
				int s = sg.index(source);
				for (int v : G.adj(s)) {
					StdOut.println("   " + sg.name(v));
				}
			} else {
				StdOut.println("input not contain '" + source + "'");
			}
		}
	}
}
