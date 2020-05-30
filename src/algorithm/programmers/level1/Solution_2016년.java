package algorithm.programmers.level1;

public class Solution_2016년 {
    public String solution(int a, int b) {
        String answer = "";
        
        int[] days = {31,29,31,30,31,30,31,31,30,31,30,31};
        String[] day = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
        
        int sum = b;
        for (int i = 0; i < a - 1; i++) {
			sum += days[i];
		}
        answer = day[sum%7];
        
        return answer;
    }
}
