package datastructure.sort;

import java.util.Arrays;

public class InsertionSort {
	public void sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if(array[j] < array[j-1]) {
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int[] array = {4,6,3,6,8,9,0,10,1,2};
		
		InsertionSort sort = new InsertionSort();
		
		sort.sort(array);
		System.out.println(Arrays.toString(array));
	}
}
