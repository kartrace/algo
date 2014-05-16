package com.mijiang.algo.prob;

import com.mijiang.algo.common.StdOut;
import com.mijiang.algo.stackqueue.Queue;

/*************************************************************************
 * Compilation: javac Josephus.java Execution: java Josephus M N Dependencies:
 * Queue.java
 * 
 * Solves the Josephus problem.
 * 
 * % java Josephus 2 7 1 3 5 0 4 2 6
 * 
 *************************************************************************/

public class JosephusProb {
	public static void main(String[] args) {
		// int M = Integer.parseInt(args[0]);
		// int N = Integer.parseInt(args[1]);

		int M = 3;
		int N = 16;
		// initialize the queue
		Queue<Integer> q = new Queue<Integer>();
		for (int i = 0; i < N; i++)
			q.enqueue(i);

		while (!q.isEmpty()) {
			for (int i = 0; i < M - 1; i++)
				q.enqueue(q.dequeue());
			StdOut.print(q.dequeue() + " ");
		}
		StdOut.println();
		
		System.out.println(josephus(16, 3));
	}

	
	//a more elaborate version using dynamic programming.
	//f(n, k) = ((f(n - 1, k) + k - 1) mod n) + 1, with f(1, k) = 1
	//f(n, k) denotes the position of the survivor.
	/**
	 * josephus(16, 3, 0)    -> 7 
	 * josephus(15, 3, 2)    -> 6
	 * josephus(14, 3, 4)    -> 5
	 * josephus(13, 3, 6)    -> 5
	 * josephus(12, 3, 8)    -> 5
	 * josephus(11, 3, 10)   -> 5
	 * josephus(10, 3, 1)    -> 4
	 * josephus(9, 3, 3)     -> 3
	 * josephus(8, 3, 5)     -> 3
	 * josephus(7, 3, 7)     -> 3
	 * josephus(6, 3, 2)     -> 2
	 * josephus(5, 3, 4)     -> 2
	 * josephus(4, 3, 1)     -> 1
	 * josephus(3, 3, 3)     -> 1
	 * josephus(2, 3, 2)     -> 1
	 * josephus(1, 3, 2)     -> 1
	 * @param n
	 * @param k
	 * @return
	 */
	static int josephus(int n, int k) {
		return josephus(n, k, 0);
	}

	static int josephus(int n, int k, int startingPoint) {
		if (n == 1)
			return 1;
		int newSp = (startingPoint + k - 2) % n + 1;

		int survivor = josephus(n - 1, k, newSp);
		if (survivor < newSp) {
			return survivor;
		} else
			return survivor + 1;
	}
}
