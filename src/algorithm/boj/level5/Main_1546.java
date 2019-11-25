package algorithm.boj.level5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1546 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] score = new int[N];
		
		int max = 0;
		for (int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
			if(max < score[i]) {
				max = score[i];
			}
		}
		
		double sum = 0;
		for (int i = 0; i < N; i++) {
			sum += (double) score[i]/max*100;
		}
		
		System.out.println(sum/N);
		
		
	}
}
