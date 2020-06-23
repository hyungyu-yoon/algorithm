package algorithm.programmers.level1;

public class Solution_비밀지도 {
	public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < arr1.length; i++) {
			String binary = Integer.toBinaryString(arr1[i] | arr2[i]);
			
			while(n > binary.length()) {
				binary = 0 + binary;
			}
        	
			answer[i] = binary.replaceAll("0", " ").replaceAll("1", "#");
		}
        
        
        return answer;
    }
}
