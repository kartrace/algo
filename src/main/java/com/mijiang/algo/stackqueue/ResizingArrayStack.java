package com.mijiang.algo.stackqueue;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item> {
	
	private Item[] a = (Item[])new Object[1];
	private int N = 0;
	
	public boolean isEmpty(){return N == 0;}
	
	public int size(){
		return N;
	}
	
	public void push(Item item){
		if (N == a.length) resize(N * 2);
		a[N++] = item;
	}
	
	public Item pop(){
		if (N == 0) return null;
		Item item = a[--N];
		a[N] = null;
		if (N <= a.length / 4) resize(a.length/2);
		return item;
	}
	
	private void resize(int size){
		Item[] temp = (Item[])new Object[size];
		for (int i = 0; i < N; i++){
			temp[i] = a[i];
		}
		a = temp;
	}

	public Iterator<Item> iterator() {
		return new ReverseOrderIterator();
	}
	
	private class ReverseOrderIterator implements Iterator<Item>{
		
		private int i = N;

		public boolean hasNext() {
			return i > 0;
		}

		public Item next() {
			return a[--i];
		}

		public void remove() {
		}
		
	}

}
