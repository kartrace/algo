package com.mijiang.algo.exercises;

public class FindMinInRotatedSortedArray {

	// no duplicates sol

	int findMin(int arr[], int low, int high) {
		// This condition is needed to handle the case when array is not
		// rotated at all
		if (high < low)
			return arr[0];

		// If there is only one element left
		if (high == low)
			return arr[low];

		// Find mid
		int mid = low + (high - low) / 2; /* (low + high)/2; */

		// Check if element (mid+1) is minimum element. Consider
		// the cases like {3, 4, 5, 1, 2}
		if (mid < high && arr[mid + 1] < arr[mid])
			return arr[mid + 1];

		// Check if mid itself is minimum element
		if (mid > low && arr[mid] < arr[mid - 1])
			return arr[mid];

		// Decide whether we need to go to left half or right half
		if (arr[high] > arr[mid])
			return findMin(arr, low, mid - 1);
		return findMin(arr, mid + 1, high);
	}

	// with dup sol
	int findMinDup(int arr[], int low, int high) {
		// This condition is needed to handle the case when array is not
		// rotated at all
		if (high < low)
			return arr[0];

		// If there is only one element left
		if (high == low)
			return arr[low];

		// Find mid
		int mid = low + (high - low) / 2; /* (low + high)/2; */

		// Check if element (mid+1) is minimum element. Consider
		// the cases like {1, 1, 0, 1}
		if (mid < high && arr[mid + 1] < arr[mid])
			return arr[mid + 1];

		// This case causes O(n) time
		if (arr[low] == arr[mid] && arr[high] == arr[mid])
			return Math.min(findMin(arr, low, mid - 1),
					findMin(arr, mid + 1, high));

		// Check if mid itself is minimum element
		if (mid > low && arr[mid] < arr[mid - 1])
			return arr[mid];

		// Decide whether we need to go to left half or right half
		if (arr[high] > arr[mid])
			return findMin(arr, low, mid - 1);
		return findMin(arr, mid + 1, high);
	}

}
