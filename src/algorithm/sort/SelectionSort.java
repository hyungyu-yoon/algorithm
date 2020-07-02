package algorithm.sort;

import java.util.Arrays;

public class SelectionSort {
	public void sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int index = i;
			for (int j = i; j < array.length; j++) {
				if(array[index] > array[j]) {
					index = j;
				}
			}
			int temp = array[index];
			array[index] = array[i];
			array[i] = temp;
		}
	}
	
	public static void main(String[] args) {
		int[] array = {4,6,3,6,8,9,0,10,1,2};
		
		SelectionSort sort = new SelectionSort();
		sort.sort(array);
		System.out.println(Arrays.toString(array));
	}
}
