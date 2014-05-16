package com.mijiang.algo.exercises;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;

public class ArrayTest1 {
	
	public static void main(String[] args){
		int[] a = new int[10];
		Random r = new Random();
		for (int i = 0; i < a.length; i++){
			a[i] = r.nextInt(10);
			System.out.print(a[i] + ",");
		}
		System.out.println();
		
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		for (int i = 0; i < a.length; i++){
			exch(a, 0, i);
			inequalty(a, 0, true, results);
		}
		
		
		for (List<Integer> sol: results){
			System.out.println();
			for (Integer i: sol)
				System.out.print(i + ",");
		}
	}
	
	private static void inequalty(int[] a, int index, boolean condition, List<List<Integer>> results){
		if (a == null || a.length == 0) return;
		if (index == a.length - 1){
			List<Integer> r = new ArrayList<Integer>();
			for (int i = 0; i < a.length; i++)
				r.add(a[i]);
			results.add(r);
		}
		else{
			for (int i = index + 1; i < a.length; i++){
				if (a[i] > a[index] == condition && a[i] != a[index]){
					if (i != index + 1)
						exch(a, i, index + 1);
					inequalty(a, index + 1, !condition, results);
				}
			}
		}
	}
	
	private static void exch(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
