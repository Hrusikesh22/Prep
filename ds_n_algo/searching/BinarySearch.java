package ds_n_algo.searching;

import java.util.Arrays;

import ds_n_algo.sorting.Utils;

public class BinarySearch {

	public static void main(String[] args) {
		int target = 99;
		int[] arr = {1,5,12,28,59,16,99,22};
		
		Arrays.sort(arr);
				
		Utils.printArray(arr, 0, "Input : ");
		
		int targetIndex = binarySearch(arr, 0, arr.length-1, target);
		
		System.out.println("\n\nIndex of Target(" + target + ") : " + targetIndex);
	}
	
	public static int binarySearch(int[] arr, int start, int end, int target) {
		
		if(start<=end) {
			int mid = (end+start)/2;
			if(arr[mid] == target)
				return mid;
			else if(arr[mid] > target) {
				return binarySearch(arr, start, mid, target);
			} else {
				return binarySearch(arr, mid+1, end, target);
			}
		} 
			
		return -1;
	}

}
