package com.mijiang.algo.stackqueue;

import com.mijiang.algo.common.StdOut;

public class ReverseQueue {

	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		Queue<String> q = new Queue<String>();
		q.enqueue("a");
		q.enqueue("b");
		q.enqueue("c");
		q.enqueue("d");
		q.enqueue("e");
		while (!q.isEmpty())
			s.push(q.dequeue());
		while (!s.isEmpty())
			q.enqueue(s.pop());
		for (String str: q){
			StdOut.print(str);
		}
	}

}
