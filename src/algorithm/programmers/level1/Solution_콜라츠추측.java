package algorithm.programmers.level1;

public class Solution_콜라츠추측 {
	public int solution(long num) {
        int answer = -1;
        
        if(num == 1) {
        	return 0;
        }
        for (int i = 1; i <= 500; i++) {
			if(num%2 == 0) {
				num/=2;
			}else {
				num = num*3 + 1;
			}
			System.out.print(num);
			
			if(num == 1) {
				answer = i;
				break;
			}
		}
        
        return answer;
    }
}
