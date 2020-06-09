package algorithm.programmers.level1;

import java.util.Arrays;

public class Solution_문자열내림차순으로배치하기 {
	public String solution(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		StringBuilder answer = new StringBuilder();
		
		for (int i = c.length - 1; i >= 0; i--) {
			answer.append(c[i]);
		}
        
        return answer.toString();
    }
}
