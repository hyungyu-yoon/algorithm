package algorithm.programmers.level2;

class Solution_쇠막대기 {
	public int solution(String arrangement) {
		
		int left = 0;
		int answer = 0;
		for (int i = 0; i < arrangement.length(); i++) {
			if(arrangement.charAt(i) == '(') {
				left++;
			}
			else {
				if(arrangement.charAt(i-1) == '(') {
					left--;
					answer += left;
				}else {
					answer++;
					left--;
				}
			}
		}
		return answer;
	}
}