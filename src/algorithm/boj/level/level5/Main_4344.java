package algorithm.boj.level.level5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4344 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int C = Integer.parseInt(br.readLine());
		
		StringTokenizer st = null;
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int[] score = new int[N];
			int sum = 0;
			for (int j = 0; j < N; j++) {
				score[j] = Integer.parseInt(st.nextToken());
				sum += score[j];
			}
			double avg =(double) sum/N;
			
			int count = 0;
			for (int j = 0; j < N; j++) {
				if(score[j] > avg) {
					count++;
				}
			}
			
			System.out.println(String.format("%.3f", (double)count/N*100)+ "%");
		}
		
	}
}
