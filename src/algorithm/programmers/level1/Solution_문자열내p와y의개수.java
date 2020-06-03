package algorithm.programmers.level1;

public class Solution_문자열내p와y의개수 {
	boolean solution(String s) {
        boolean answer = true;

        int count = 0;
        s = s.toLowerCase();
        for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'p') {
				count++;
			}else if(s.charAt(i) == 'y') {
				count--;
			}
		}
        answer = count == 0 ? true : false;

        return answer;
    }
}
