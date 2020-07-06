package algorithm.programmers.level2;

import java.util.ArrayList;

class Solution_기능개발 {
	public int[] solution(int[] progresses, int[] speeds) {

		int[] realease = new int[progresses.length];
		for (int i = 0; i < progresses.length; i++) {
			
			realease[i] = (100 - progresses[i])/speeds[i] + ((100 - progresses[i])%speeds[i] != 0 ? 0 : 1);
			
		}
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int temp = realease[0];
		int count = 1;
		for (int i = 1; i < realease.length; i++) {
			if(temp <= realease[i]) {
				count++;
			}else {
				list.add(count);
				temp = realease[i];
				count = 1;
			}
		}
		list.add(count);
		
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}