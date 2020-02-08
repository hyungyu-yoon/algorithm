package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_8888_시험 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			int[][] student = new int[n][t];
			int[] sum = new int[n];
			int[] solve = new int[n];
			int[] score = new int[t]; 
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < t; j++) {
					student[i][j] = Integer.parseInt(st.nextToken());
					score[j] = student[i][j] == 0 ? ++score[j] : score[j];
					solve[i] = student[i][j] == 1 ? ++solve[i] : solve[i];
				}
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < t; j++) {
					sum[i] = student[i][j] == 1 ? sum[i] + score[j] : sum[i];
				}
			}
			
			int rank = 1;
			for (int i = 0; i < n; i++) {
				if(i == p-1) {
					continue;
				}
				
				if(sum[p-1] < sum[i]) {
					rank++;
				}
				
				if(sum[p-1] == sum[i]) {
					if(solve[p-1] < solve[i]) {
						rank++;
					}
					
					if(solve[p-1] == solve[i] && p-1 > i) {
						rank++;
					}
				}
			}

			
			
			System.out.println("#" + tc+ " " + sum[p-1] +" " + rank);
		}
	}

}
