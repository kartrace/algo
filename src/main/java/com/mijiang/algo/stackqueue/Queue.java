package com.mijiang.algo.stackqueue;

import java.util.Iterator;
import java.util.NoSuchElementException;


public class Queue<Item> implements Iterable<Item> {
	
	private int N;
	
	private Node first;
	
	private Node last;
	
	public int size(){return N;}
	
	public boolean isEmpty() {return N == 0;}
	
	public Item peek(){
		if (isEmpty()) throw new NoSuchElementException("Nothing in queue");
		return first.item;
	}
	
	public void enqueue(Item item){
		Node oldLast = last;
		last = new Node(item);
		if (N == 0)
			first = last;
		else
			oldLast.next = last;
		N++;
	}
	
	public Item dequeue(){
		if (N == 0) throw new NoSuchElementException("Nothing in queue");
		Item item = first.item;
		if (N == 1){
			first = null;
			last = null;
		}else{
			first = first.next;
		}
		N--;
		return item;
	}
	
	private class Node{
		Item item;
		Node next;
		
		Node(Item item){this.item = item;}
	}

	public Iterator<Item> iterator() {
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<Item>{

		Node temp = first;

		public boolean hasNext() {
			return temp != null;
		}

		public Item next() {
			if (!hasNext()) throw new NoSuchElementException("queue is empty");
			Item item = temp.item;
			temp = temp.next;
			return item;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}

}
