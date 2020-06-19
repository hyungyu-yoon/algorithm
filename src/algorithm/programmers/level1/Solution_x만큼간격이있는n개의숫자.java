package algorithm.programmers.level1;

public class Solution_x만큼간격이있는n개의숫자 {
	public long[] solution(int x, int n) {
		long[] answer = new long[n];
		
		answer[0] = x;
		for (int i = 1; i < answer.length; i++) {
			answer[i] = answer[i-1] + x;
		}
		
		return answer;
	}
}
