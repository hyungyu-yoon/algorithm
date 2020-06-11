package algorithm.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_자연수뒤집어배열로만들기 {
	public int[] solution(long n) {
		
		ArrayList<Integer> list = new ArrayList<>();
		String s = n + "";
		for (int i = s.length() -1; i >= 0; i--) {
			list.add(s.charAt(i) - '0');
		}
		
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		Solution_자연수뒤집어배열로만들기 s = new Solution_자연수뒤집어배열로만들기();
		
		System.out.println(Arrays.toString(s.solution(10000000000L)));
	}
}
