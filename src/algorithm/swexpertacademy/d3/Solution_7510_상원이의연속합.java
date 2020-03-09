package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7510_상원이의연속합 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			
			int count = 0;
			
			for (int i = 0; i < N; i++) {
				int a = 2*N-i*i-i;
				int b = 2*(i+1);
				
				if(a <= 0) {
					break;
				}
				
				if(a%b == 0) {
					count++;
				}
			}
			
			System.out.println("#"+ tc + " " + count);
		}
	}
	
}
