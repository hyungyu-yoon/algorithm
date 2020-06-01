package algorithm.programmers.level1;

import java.util.*;

public class Solution_같은숫자는싫어 {
	public int[] solution(int[] arr) {
		int[] answer = {};

		ArrayList<Integer> list = new ArrayList<>();
		int cur = arr[0];
		list.add(cur);
		for (int i = 1; i < arr.length; i++) {
			if(cur == arr[i]) {
				continue;
			}else {
				cur = arr[i];
				list.add(cur);
			}
			
		}
		
		answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}
}
