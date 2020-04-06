package common;

import java.util.Arrays;

public class Permutation {
	static int cnt=0;
	public static void main(String[] args) {
		int[] array = {1,2,3,4};
		
		perm(array, 0);
		System.out.println("cnt="+cnt);
	}
	
	static void perm(int[] arr, int d) {
		if(d==arr.length) { 
			System.out.println(Arrays.toString(arr));
			cnt++; 
			return;
		}
		
		for(int i=d; i<arr.length; i++) {
			swap(arr, i, d);
			perm(arr,d+1);
			swap(arr, i, d);
		}
	}
	
	static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
