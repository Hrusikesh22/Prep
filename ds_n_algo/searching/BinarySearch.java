package ds_n_algo.searching;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		int target = 99;
		int[] arr = {1,5,12,28,59,16,99,22};
		Arrays.sort(arr);
		System.out.print("Input : ");
		for(int i : arr)
			System.out.print(i + " ");
		int targetIndex = binarySearch(arr, target, 0, arr.length-1);
		
		System.out.println("\nIndex of Target " + target + " - " + targetIndex);
	}
	
	public static int binarySearch(int[] arr, int target, int start, int end) {
		
		if(start<=end) {
			int mid = (end+start)/2;
			if(arr[mid] == target)
				return mid;
			else if(arr[mid] > target) {
				return binarySearch(arr, target, start, mid);
			} else {
				return binarySearch(arr, target, mid+1, end);
			}
		} 
			
		return -1;
	}

}
