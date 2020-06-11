package algorithm.programmers.level1;

import java.util.Arrays;

public class Solution_정수내림차순으로배치하기 {
	public long solution(long n) {
        long answer = 0;
        String s = n + "";
        
        int[] array = new int[s.length()];
        for (int i = 0; i < array.length; i++) {
			array[i] = s.charAt(i) - '0';
		}
        
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
			sb.append(array[i]);
		}
        
        answer = Long.parseLong(sb.reverse().toString());
        
        
        return answer;
    }
}
