package algorithm.sort;

import java.util.Arrays;

public class QuickSort {

	
	public void quickSort(int[] data, int start, int end){
        int left = start;
        int right = end;
        int pivot = data[(start + end)/2];
        
        while (left <= right) {
            while(data[left] < pivot) 
              left++;
            while(data[right] > pivot) 
              right--;
            if(left <= right){    
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;
                left++;
                right--;
            }
        } 
        
        if(start < right) 
          quickSort(data, start, right); 
      
        if(end > left) 
          quickSort(data, left, end); 
    }

	
	public static void main(String[] args) {
		QuickSort quick = new QuickSort();
		int[] array = {5,4,3,2,4,5,7,8};
		quick.quickSort(array, 0, array.length-1);
		
		System.out.println(Arrays.toString(array));
		
	}
}
