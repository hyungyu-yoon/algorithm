package algorithm.swexpertacademy.swtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2105_디저트카페 {
	static int N;
	static int[][] cafe;
	static boolean[] used;
	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, -1, 1 };
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			cafe = new int[N][N];

			StringTokenizer st = null;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					cafe[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			max = -1;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int a = 1; a < N; a++) {
						for (int b = 1; b < N; b++) {
							if (j + a >= N || i + a + b >= N || j - b < 0 || ((a+b)*2) <= max) {
								continue;
							}
							used = new boolean[101];
							boolean check = false;

							used[cafe[i][j]] = true;
							int x =i;
							int y =j;
							for (int k = 0; k < a; k++) {
								x += dx[0];
								y += dy[0];
								
								if(used[cafe[x][y]]) {
									check = true;
									break;
								}
								used[cafe[x][y]] = true;
							}
							
							if(check) {
								continue;
							}

							for (int k = 0; k < b; k++) {
								x += dx[1];
								y += dy[1];
								
								if(used[cafe[x][y]]) {
									check = true;
									break;
								}
								used[cafe[x][y]] = true;
							}
							
							if(check) {
								continue;
							}

							for (int k = 0; k < a; k++) {
								x += dx[2];
								y += dy[2];
								
								if(used[cafe[x][y]]) {
									check = true;
									break;
								}
								used[cafe[x][y]] = true;
							}
							
							if(check) {
								continue;
							}

							for (int k = 0; k < b-1; k++) {
								x += dx[3];
								y += dy[3];
								
								if(used[cafe[x][y]]) {
									check = true;
									break;
								}
								used[cafe[x][y]] = true;
							}
							
							if(check) {
								continue;
							}
							
							max = Math.max(max, (a+b)*2);
							
						}
					}
				}
			}
			System.out.println("#" + tc + " " + max);
		}

	}
}
