package com.mijiang.algo.stackqueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item>{
	
	private Node first;
	private int N = 0;
	
	public Stack() {
		first = null;
		N = 0;
	}
	
	private class Node{
		private Item item;
		private Node next;
	}
	
	public boolean isEmpty(){return N == 0;}
	public int size(){return N;}
	
	public void push(Item item){
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}
	
	public Item pop(){
		if (isEmpty()) throw new NoSuchElementException("Stack is empty.");
		Item item = first.item;
		first = first.next;
		N--;
		return item;
	}
	
	public Item peek(){
		if (isEmpty()) throw new NoSuchElementException("Stack is empty.");
		return first.item;
	}
	
	public Iterator<Item> iterator(){ return new StackIterator();}
	
	private class StackIterator implements Iterator<Item>{
		
		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public Item next() {
			if (!hasNext()) throw new NoSuchElementException("stack is empty.");
			Item item = current.item;
			current = current.next;
			return item;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}

}
