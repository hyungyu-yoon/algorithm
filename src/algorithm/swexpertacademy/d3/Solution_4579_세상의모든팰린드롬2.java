package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_4579_세상의모든팰린드롬2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			
			boolean isPalindrome = true;
			
			int len = str.length();
			for (int i = 0; i < len/2; i++) {
				char c1 = str.charAt(i);
				char c2 = str.charAt(len - 1 - i);
				
				if(c1 == '*' || c2 == '*') {
					break;
				}
				
				if(c1 != c2) {
					isPalindrome = false;
					break;
				}
			}
			System.out.println("#" + tc + " " + (isPalindrome ? "Exist" : "Not exist"));
		}
	}
	
}
