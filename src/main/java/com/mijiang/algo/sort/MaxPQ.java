package com.mijiang.algo.sort;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MaxPQ<E extends Comparable<E>> implements Iterable<E> {

	private E[] pq;
	private int N;
	
	public MaxPQ(int initCapacity){
		pq = (E[])new Object[initCapacity + 1];
	}
	
	public MaxPQ(){
		this(1);
	}
	
	public MaxPQ(E[] elements){
		N = elements.length;
		pq = (E[])new Object[N + 1];
		for (int i = 0; i < N; i++)
			pq[i + 1] = elements[i];
		for (int i = N / 2; i >= 1; i--)
			sink(i);
	}
	
	public E max(){
		if (isEmpty()) return null;
		return pq[1];
	}
	
	public void insert(E e){
		if (N >= pq.length - 1) resize(N * 2);
		pq[++N] = e;
		swim(N);
	}
	
	public E delMax(){
		if (isEmpty())
			return null;
		E r = pq[1];
		exch(1, N);
		pq[N--] = null;
		sink(1);
		if (N > 0 && N == (pq.length - 1) / 4) resize ( pq.length / 2);
		return r;
	}
	
	public int size() {return N;}
	
	public boolean isEmpty(){return N == 0;}

	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k / 2, k);
			k = k / 2;
		}
	}

	private void sink(int k) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(j, j + 1))
				j++;
			if (less(j, k))
				break;
			exch(k, j);
			k = j;
		}
	}

	private boolean less(int a, int b) {
		return pq[a].compareTo(pq[b]) < 0 ? true : false;
	}

	private void exch(int a, int b) {
		E tmp = pq[a];
		pq[a] = pq[b];
		pq[b] = tmp;
	}

	public Iterator<E> iterator() {
		return new HeapIterator();
	}
	
	private void resize(int capacity){
		E[] temp = (E[])new Object[capacity + 1];
		for (int i = 1; i <= N; i++)
			temp[i] = pq[i];
		pq = temp;
	}
	
	private boolean isMaxHeap(){
		return isMaxHeap(1);
	}

	private boolean isMaxHeap(int k) {
		if (k > N) return true;
		int left = 2 * k, right = 2 * k + 1;
		if (left <= N && less(k, left)) return false;
		if (right <= N && less(k, right)) return false;
		return isMaxHeap(left) && isMaxHeap(right);
	}
	
	private class HeapIterator implements Iterator<E>{
		
		private MaxPQ<E> copy;
		
		HeapIterator(){
			copy = new MaxPQ<E>(N);
			for (int i = 1; i <= N; i++)
				copy.insert(pq[i]);
		}

		public boolean hasNext() {
			return copy.size() > 0;
		}

		public E next() {
			if (!hasNext()) throw new NoSuchElementException();
			return copy.delMax();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
		
	}

}
