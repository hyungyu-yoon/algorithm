package algorithm.search;

public class SequentialSearch {

	public static void main(String[] args) {
		SequentialSearch search = new SequentialSearch();

		int[] array = { 1, 5, 2, 4, 3, 6, 7, 8, 9, 10 };

		// 존재
		System.out.println(search.sequentialSearch(array, 5));

		// 없음
		System.out.println(search.sequentialSearch(array, 20));

	}

	public int sequentialSearch(int[] array, int number) {
		int index = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == number) {
				index = i;
				break;
			}
		}

		return index;
	}
}
