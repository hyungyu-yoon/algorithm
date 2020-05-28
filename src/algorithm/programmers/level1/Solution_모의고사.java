package algorithm.programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

public class Solution_모의고사 {
	public int[] solution(int[] answers) {
		int[] answer = new int[3];
		
		int[] a = {1,2,3,4,5};
		int[] b = {2,1,2,3,2,4,2,5};
		int[] c = {3,3,1,1,2,2,4,4,5,5};
		
		int max = 0;
		for (int i = 0; i < answers.length; i++) {
			if(a[i%5] == answers[i]) {
				answer[0]++;
			}
			
			if(b[i%8] == answers[i]) {
				answer[1]++;
			}
			
			if(c[i%10] == answers[i]) {
				answer[2]++;
			}
			
		}
		max = Math.max(max, answer[0]);
		max = Math.max(max, answer[1]);
		max = Math.max(max, answer[2]);
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < answer.length; i++) {
			if(max == answer[i]) {
				list.add(i+1);
			}
		}
		
		answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}
}
