package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_3750_Digitsum {
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String N = br.readLine();
			
			while(N.length() > 1) {
				long sum = 0;
				for (int i = 0; i < N.length(); i++) {
					sum += N.charAt(i) - '0';
				}
				N = sum + "";
			}
			
			System.out.println("#" +tc + " " + N);
		}
		
	}
	
}
