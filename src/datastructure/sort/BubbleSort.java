package datastructure.sort;

import java.util.Arrays;

public class BubbleSort {
	public void sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array.length-i; j++) {
				if (array[j] < array[j - 1]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] array = {9,8,7,6,5,4,3,2,1};

		BubbleSort sort = new BubbleSort();

		sort.sort(array);
		System.out.println(Arrays.toString(array));
	}
}
