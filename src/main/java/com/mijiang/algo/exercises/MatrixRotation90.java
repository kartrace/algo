package com.mijiang.algo.exercises;

/*
 * 1 2 3 
 * 6 7 8
 * 9 8 7 
 * 
 * 9 6 1
 * 8 7 2
 * 7 8 3
 * 
 * 
 * (0, 0) -> (0, 2)
 * (0, 2) -> (2, 2)
 * (2, 2) -> (2, 0)
 * (2, 0) -> (0, 0)
 */

public class MatrixRotation90 {

	public void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = temp;
			}
		}
	}

}
