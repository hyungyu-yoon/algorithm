package algorithm.programmers.level1;

public class Solution_문자열다루기기본 {
	public boolean solution(String s) {
		boolean answer = true;
		if(s.length() == 4 || s.length() == 6) {
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) - '0' > 10 ) {
					answer = false;
					break;
				}
			}
		}else {
			answer = false;
		}
		return answer;
	}
}
