package com.currency.service;

import com.database.algorithms.Utilities;

public class ReverseMergeSort {


	/**
	 * This will merge the subsets into the single entity
	 */
	public static void merge(int[] array, int left, int mid, int right) {

		int leftSize = mid - left + 1;
		int rightSize = right - mid ;

		int leftArray[] = new int[leftSize];
		int rightArray[] = new int[rightSize];

		// start copying the left and right portion into these arrays

		for (int index = 0; index < leftSize; index++) {
			leftArray[index] = array[left + index];
		}
		for (int index = 0; index < rightSize; index++) {
			rightArray[index] = array[mid + 1 + index];
		}

		int i = 0;
		int j = 0;
		int k = left;

		while (i < leftSize && j < rightSize) {
			if (leftArray[i] >= rightArray[j]) {
				array[k] = leftArray[i];
				i++;
			} 
			else {
				array[k] = rightArray[j];
				j++;
			}
			k++;
		}

		while (i < leftSize) {
			array[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < rightSize) {
			array[k] = rightArray[j];
			j++;
			k++;
		}
	}

	/**
	 * Recursion to subdivide the problem Results of recursion will be merged
	 * 
	 */
	public static void reversemergeSort(int[] array, int left, int right) {

		if (left < right) { // Terminating Condition
			int mid = (left + right) / 2;
			/*
			 * Helps us divide array into 2 portions 1 - (left to mid ) 2 - (mid+1 to right)
			 */
			reversemergeSort(array, left, mid);
			reversemergeSort(array, mid + 1, right);
			merge(array, left, mid, right);
		}
	}
	

	public static void main(String[] args) {
		int[] array = Utilities.getDataofArray();
		reversemergeSort(array,0,array.length-1);
		Utilities.displayArray(array);
	}

}
