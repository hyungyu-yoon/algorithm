package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2817_부분수열의합 {
	static int[] arr;
	static int N,K,count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			count = 0;
			solve(0, 0);
			System.out.println("#" + tc + " " + count);
		}
	}
	
	static void solve(int index, int sum) {
		if(sum == K) {
			count++;
			return;
		}
		
		if(sum > K || index >= N) {
			return;
		}
		
		solve(index+1, sum + arr[index]);
		solve(index+1, sum);
	}
	
}
