package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_9229_한빈이와SpotMart {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] ai = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				ai[i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			for (int i = 0; i < N; i++) {
				int sum = ai[i];
				if(sum > M) {
					continue;
				}
				for (int j = i+1; j < N; j++) {
					sum += ai[j];
					if(sum > M) {
						sum -= ai[j];
						continue;
					}
					max = Math.max(max, sum);
					sum -= ai[j];
				}
			}
			System.out.println("#" + tc+ " " + (max == 0 ? -1 : max) );
		}
	}

}
