package algorithm.programmers.level1;

public class Solution_핸드폰번호가리기 {
	public String solution(String phone_number) {
        String answer = "";
        
        for (int i = 0; i < phone_number.length(); i++) {
        	if (phone_number.length()-4 > i) {
				answer += "*";
			}else {
				answer += phone_number.charAt(i);
			}
		}
        return answer;
    }
}
