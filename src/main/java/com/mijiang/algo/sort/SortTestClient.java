package com.mijiang.algo.sort;

import java.util.Arrays;
import java.util.Collections;

import com.mijiang.algo.common.FileOut;
import com.mijiang.algo.common.StdOut;
import com.mijiang.algo.common.StdRandom;
import com.mijiang.algo.common.Stopwatch;

import static com.mijiang.algo.sort.SortHelper.*;

public class SortTestClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		filePrintHeader();
		for (int N = 10000; N <= 50000000; N *= 1.25) {
			long seed = System.currentTimeMillis();
			
//			Integer[] toSortData = genRandomInt(N, seed);
//            double time1 = selectionSort(toSortData);
//            
//            toSortData = genRandomInt(N, seed);
//            double time2 = insertionSort(toSortData);
//            
//            Integer[] toSortData7 = genRandomInt(N, seed);
//            double time3 = bubbleSort(toSortData7);
			Stopwatch timer = new Stopwatch();
            Integer[] toSortData = genRandomInt(N, seed);
            double genRandomTime = timer.elapsedTime();
//            double time4 = shellSort(toSortData);
//            
//            toSortData = genRandomInt(N, seed);
//            double time5 = mergeSort(toSortData);
//            
//            toSortData = genRandomInt(N, seed);
//            double time6 = mergeXSort(toSortData);
//            
//            toSortData = genRandomInt(N, seed);
//            double time7 = mergeBottomUpSort(toSortData);
            
            double time8 = quickSort(toSortData);
            
            toSortData = genRandomInt(N, seed);
            double time9 = quick3WaySort(toSortData);
            
            toSortData = genRandomInt(N, seed);
            double time10 = quickXSort(toSortData);
     
            toSortData = genRandomInt(N, seed);
            double time11 = quickMidSort(toSortData);
//            StdOut.printf("%9d\t%6.1f\t%s\t%s\n", N, time11, "quickMid", isSorted(toSortData));
        
//            StdOut.printf("%9d\t%6.1f\t%s\n", N, time1, "selection");
//            StdOut.printf("%9d\t%6.1f\t%s\n", N, time2, "insertion");
//            StdOut.printf("%9d\t%6.1f\t%s\n", N, time3, "bubble");
//            StdOut.println("gen random int[] consumed: " + genRandomTime);
//            StdOut.printf("%9d\t%6.1f\t%s\n", N, time4, "shellsort");
//            StdOut.printf("%9d\t%6.1f\t%s\n", N, time5, "mergesort");
//            StdOut.printf("%9d\t%6.1f\t%s\n", N, time6, "mergeXSort");
//            StdOut.printf("%9d\t%6.1f\t%s\n", N, time7, "mergeBottomUpSort");
            StdOut.printf("%9d\t%6.1f\t%s\n", N, time8, "quick");
            StdOut.printf("%9d\t%6.1f\t%s\n", N, time9, "quick3way");
            StdOut.printf("%9d\t%6.1f\t%s\n", N, time10, "quickX");
            StdOut.printf("%9d\t%6.1f\t%s\n", N, time11, "quickMid");
            
            
//            filePrint(N, time1, "selection");
//            filePrint(N, time2, "insertion");
//            filePrint(N, time3, "bubble");
//            filePrint(N, time4, "shellsort");
//            filePrint(N, time5, "mergesort");
//            filePrint(N, time6, "mergeXSort");
//            filePrint(N, time7, "mergeBottomUpSort");
            filePrint(N, time8, "quick");
            filePrint(N, time9, "quick3way");
            filePrint(N, time10, "quickX");
            filePrint(N, time11, "quickMid");
         
        }
	}
	
	private static void print(Object[] data) {
		for (Object obj: data)
			StdOut.print(obj + ",");
		StdOut.println();
	}

	private static double quickMidSort(Integer[] toSortData){
		Stopwatch timer = new Stopwatch();
		QuickMid.sort(toSortData);
		return timer.elapsedTime();
	}
	
	private static double quickXSort(Integer[] toSortData){
		Stopwatch timer = new Stopwatch();
		QuickX.sort(toSortData);
		return timer.elapsedTime();
	}
	
	private static double quick3WaySort(Integer[] toSortData){
		Stopwatch timer = new Stopwatch();
		Quick3Way.sort(toSortData);
		return timer.elapsedTime();
	}
	
	private static double quickSort(Integer[] toSortData) {
		Stopwatch timer = new Stopwatch();
		QuickSort.sort(toSortData);
		return timer.elapsedTime();
	}

	private static double bubbleSort(Integer[] toSortData) {
		Stopwatch timer = new Stopwatch();
		BubbleSort.sort(toSortData);
		return timer.elapsedTime();
	}
	
	private static double mergeXSort(Integer[] toSortData) {
		Stopwatch timer = new Stopwatch();
		MergeXSort.sort(toSortData);
		return timer.elapsedTime();
	}
	
	private static double mergeBottomUpSort(Integer[] toSortData) {
		Stopwatch timer = new Stopwatch();
		MergeBottomUp.sort(toSortData);
		return timer.elapsedTime();
	}
	
	private static double mergeSort(Integer[] toSortData) {
		Stopwatch timer = new Stopwatch();
		MergeSort.sort(toSortData);
		return timer.elapsedTime();
	}
	
	private static double shellSort(Integer[] toSortData) {
		Stopwatch timer = new Stopwatch();
		ShellSort.sort(toSortData);
		return timer.elapsedTime();
	}

	private static double insertionSort(Integer[] toSortData) {
		Stopwatch timer = new Stopwatch();
		Insertion.sort(toSortData);
		return timer.elapsedTime();
	}

	private static void filePrintHeader() {
		FileOut.print("size");
        FileOut.print("\t");
        FileOut.print("time");
        FileOut.print("\t");
        FileOut.println("algo");
	}

	private static void filePrint(int n, double time, String algo) {
		FileOut.print(n);
        FileOut.print("\t");
        FileOut.print(time);
        FileOut.print("\t");
        FileOut.println(algo);
	}

	private static double selectionSort(Integer[] toSortData) {
		Stopwatch timer = new Stopwatch();
		Selection.sort(toSortData);
		return timer.elapsedTime();
	}

	public static Integer[] genRandomInt(int n) {
		Integer[] data = new Integer[n];
		for (int i = 0; i < n; i++)
			data[i] = StdRandom.uniform(n/10000);
		return data;
	}
	
	private static Integer[] genRandomInt(int n, long seed){
		StdRandom.setSeed(seed);
		return genRandomInt(n);
	}
	

}
