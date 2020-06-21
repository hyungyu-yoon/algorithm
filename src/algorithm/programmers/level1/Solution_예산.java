package algorithm.programmers.level1;

import java.util.Arrays;

public class Solution_예산 {
	public int solution(int[] d, int budget) {
		int answer = 0;
		int count = 0;
		int sum = 0;
		
		Arrays.sort(d);
		for (int i = 0; i < d.length; i++) {
			sum += d[i];
			if(sum > budget) {
				break;
			}
			count++;
		}
		answer = count;
		return answer;
	}
	
	
}
