package algorithm.search;

public class BinarySearch {
	
	public static void main(String[] args) {
		BinarySearch binarySearch = new BinarySearch();
		
		int[] array = {1,2,3,4,6,7,8,9,10};
		System.out.println(binarySearch.binarySearch(array, 5));
	}

	public int binarySearch(int[] array, int number) {
		int left = 0;
		int right = array.length - 1;
		int mid;
		int index = -1;
		while(left <= right) {
			mid = (left+right)/2;
			
			if(array[mid] == number) {
				index = mid;
				break;
			}
			
			if(array[mid] > number) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		
		return index;
	}
}
