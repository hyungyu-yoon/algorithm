package algorithm.programmers.level1;

public class Solution_정수제곱근판별 {
	public long solution(long n) {
		long answer = 0;
		long num = (long) Math.sqrt(n);
		
		if(num*num == n) {
			answer = (num+1)*(num+1);
		}else {
			answer = -1;
		}
		
		return answer;
	}
}
