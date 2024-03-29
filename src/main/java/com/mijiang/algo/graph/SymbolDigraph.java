package com.mijiang.algo.graph;

import com.mijiang.algo.common.StdIn;
import com.mijiang.algo.common.StdOut;
import com.mijiang.algo.search.ST;
import com.mijiang.algo.stackqueue.In;

/**
 * The <tt>SymbolDigraph</tt> class represents a digraph, where the vertex names
 * are arbitrary strings. By providing mappings between string vertex names and
 * integers, it serves as a wrapper around the {@link Digraph} data type, which
 * assumes the vertex names are integers between 0 and <em>V</em> - 1. It also
 * supports initializing a symbol digraph from a file.
 * <p>
 * This implementation uses an {@link ST} to map from strings to integers, an
 * array to map from integers to strings, and a {@link Digraph} to store the
 * underlying graph. The <em>index</em> and <em>contains</em> operations take
 * time proportional to log <em>V</em>, where <em>V</em> is the number of
 * vertices. The <em>name</em> operation takes constant time.
 * <p>
 * For additional documentation, see <a
 * href="http://algs4.cs.princeton.edu/42digraph">Section 4.2</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 * 
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class SymbolDigraph {
	private ST<String, Integer> st; // string -> index
	private String[] keys; // index -> string
	private Digraph G;

	/**
	 * Initializes a digraph from a file using the specified delimiter. Each
	 * line in the file contains the name of a vertex, followed by a list of the
	 * names of the vertices adjacent to that vertex, separated by the
	 * delimiter.
	 * 
	 * @param filename
	 *            the name of the file
	 * @param delimiter
	 *            the delimiter between fields
	 */
	public SymbolDigraph(String filename, String delimiter) {
		st = new ST<String, Integer>();

		// First pass builds the index by reading strings to associate
		// distinct strings with an index
		In in = new In(filename);
		while (in.hasNextLine()) {
			String[] a = in.readLine().split(delimiter);
			for (int i = 0; i < a.length; i++) {
				if (!st.contains(a[i]))
					st.put(a[i], st.size());
			}
		}

		// inverted index to get string keys in an aray
		keys = new String[st.size()];
		for (String name : st.keys()) {
			keys[st.get(name)] = name;
		}

		// second pass builds the digraph by connecting first vertex on each
		// line to all others
		G = new Digraph(st.size());
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
	 * Does the digraph contain the vertex named <tt>s</tt>?
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
	 * Returns the digraph assoicated with the symbol graph. It is the client's
	 * responsibility not to mutate the digraph.
	 * 
	 * @return the digraph associated with the symbol digraph
	 */
	public Digraph G() {
		return G;
	}

	/**
	 * Unit tests the <tt>SymbolDigraph</tt> data type.
	 */
	public static void main(String[] args) {
		String filename = args[0];
		String delimiter = args[1];
		SymbolDigraph sg = new SymbolDigraph(filename, delimiter);
		Digraph G = sg.G();
		while (!StdIn.isEmpty()) {
			String t = StdIn.readLine();
			for (int v : G.adj(sg.index(t))) {
				StdOut.println("   " + sg.name(v));
			}
		}
	}
}
