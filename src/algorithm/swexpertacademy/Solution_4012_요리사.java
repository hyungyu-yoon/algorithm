package algorithm.swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {
	static int N;
	static int[][] food;
	static boolean[] used;
	static int min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			food = new int[N][N];

			StringTokenizer st = null;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					food[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			used = new boolean[N];
			min = Integer.MAX_VALUE;
			perm(0,0);
			System.out.println("#" + tc + " " + min);
		}
	}

	public static void perm(int d, int cnt) {
		if(d >= N || cnt > N/2) {
			return;
		}
		if(cnt == N/2) {
			int[] A = new int[N/2];
			int[] B = new int[N/2];
			int idx1 = 0;
			int idx2 = 0;
			for (int i = 0; i < used.length; i++) {
				if(used[i]) {
					A[idx1++] = i;
				}else {
					B[idx2++] = i;
				}
			}
			
			
			min = Math.min(min, Math.abs(calc(A)-calc(B)));
			return;
		}
		
		used[d] = true;
		perm(d+1,cnt+1);
		used[d] = false;
		perm(d+1,cnt);
		
	}
	
	static public int calc(int[] array) {
		int sum = 0;
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < N/2; j++) {
				sum += food[array[i]][array[j]];
			}
		}
		return sum;
	}
}
