package algorithm.swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4008_숫자만들기 {
	static int N;
	static int[] op;
	static int[] num;
	static int max;
	static int min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			op = new int[4];
			num = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				op[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			dfs(1,num[0]);
			System.out.println("#" + tc + " " + (max-min));
		}
	}
	
	public static void dfs(int d, int val) {
		if(d == N) {
			min = Math.min(min, val);
			max = Math.max(max, val);
			return;
		}
		
		if(op[0] > 0) {
			op[0]--;
			dfs(d+1,val+num[d]);
			op[0]++;
		}
		
		if(op[1] > 0) {
			op[1]--;
			dfs(d+1,val-num[d]);
			op[1]++;
		}
		
		if(op[2] > 0) {
			op[2]--;
			dfs(d+1,val*num[d]);
			op[2]++;
		}
		
		if(op[3] > 0) {
			op[3]--;
			dfs(d+1,val/num[d]);
			op[3]++;
		}
	}
}
