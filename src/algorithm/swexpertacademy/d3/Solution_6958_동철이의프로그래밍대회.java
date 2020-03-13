package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_6958_동철이의프로그래밍대회 {
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int max = 0;
			int count = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int solve = 0;
				for (int j = 0; j < M; j++) {
					if(Integer.parseInt(st.nextToken()) == 1) {
						solve++;
					}
				}
				
				if(solve > max) {
					max = solve;
					count = 1;
				}else if(solve == max) {
					count++;
				}
			}
			System.out.println("#" + tc + " " + count + " " + max);
		}
	}
	
}
