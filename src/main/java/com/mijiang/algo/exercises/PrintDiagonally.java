package com.mijiang.algo.exercises;


public class PrintDiagonally {
	
	public static void print(int a[][]){
	     if (a == null || a.length == 0) return;
	     int numRows = a.length;
	     int numCols = a[0].length;
	     for (int j = 0; j < numCols; j++){
	         for (int i = 0, k = j; i < numRows && k >= 0; i++, k--){
	             System.out.print(a[i][k] + ",");
	         }
	         System.out.println();
	     }
	     for (int i = 1; i < numRows; i++){
	         for (int j = numCols - 1, k = i; k < numRows && j >= 0; k++, j--)
	             System.out.print(a[k][j] + ",");
	         System.out.println();
	     }
	 }
	
	public static void main(String[] args){
		int[][] a = new int[3][7];
	    for (int i = 0; i < a.length; i++)
	    	for (int j = 0; j < a[i].length; j++)
	    		a[i][j] = j+1;
	    print(a);
	}

}
