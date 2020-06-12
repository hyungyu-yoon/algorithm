package algorithm.programmers.level1;

import java.util.Arrays;

public class Solution_제일작은수제거하기 {
	public int[] solution(int[] arr) {
		
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if(min > arr[i]) {
				min = arr[i];
			}
		}
		
		int[] answer = new int[arr.length-1];
		if(arr.length == 1) {
			return new int[] {-1};
		}
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if(min == arr[i]) {
				continue;
			}
			answer[index++] = arr[i];
		}
		
		
		return answer;
	}
}
