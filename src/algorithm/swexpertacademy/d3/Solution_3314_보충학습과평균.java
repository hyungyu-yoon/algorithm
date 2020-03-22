package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3314_보충학습과평균 {
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int sum = 0;
			while(st.hasMoreTokens()) {
				int score = Integer.parseInt(st.nextToken());
				if(score < 40) {
					score = 40;
				}
				
				sum += score;
			}
			
			System.out.println("#" + tc+ " " + sum/5);
		}
	}
	
}
