package algorithm.programmers.level1;

public class Solution_소수찾기 {
	public int solution(int n) {
		int answer = 0;
		
		for (int i = 2; i <= n; i++) {
			double sqrt = Math.sqrt(i);
			boolean check = true;
			for (int j = 2; j <= sqrt; j++) {
				if(i%j == 0) {
					check = false;
					break;
				}
			}
			if(check) {
				answer++;
			}
		}
		return answer;
	}
}
