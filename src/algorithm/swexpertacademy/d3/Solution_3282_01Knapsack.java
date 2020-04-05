package algorithm.swexpertacademy.d3;

import java.io.*;
import java.util.*;

public class Solution_3282_01Knapsack {
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] size = new int[N];
			int[] value = new int[N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				size[i] = Integer.parseInt(st.nextToken());
				value[i] = Integer.parseInt(st.nextToken());
			}
			
			
			int[][] dp = new int[N+1][K + 1];
			for (int i = 1; i <= N; i++) {
				for (int j = 0; j <= K; j++) {
					if(size[i-1] > j) {
						dp[i][j] = dp[i-1][j];
					}else {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - size[i-1]] + value[i-1]);
					}
				}
			}
			
			System.out.println("#" +tc + " " + dp[N][K]);
		}
	}
	
}
