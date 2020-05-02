package algorithm.boj.sstest;

import java.io.*;
import java.util.*;

public class Main_17779_게리멘더링2 {
	static int N;
	static int[][] A;
	static int[][] R;
	static int[] sum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		A = new int[N + 2][N + 2];
		R = new int[N + 2][N + 2];
		StringTokenizer st = null;
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = Integer.MAX_VALUE;
		
		for (int x = 1; x <= N; x++) {
			for (int y = 1; y <= N; y++) {
				for (int d1 = 1; d1 <= N; d1++) {
					for (int d2 = 1; d2 <= N; d2++) {
						if (x < x + d1 + d2 && x + d1 + d2 <= N && 1 < y-d1 && y-d1 < y && y+d2 <= N) {
							init();
							for (int i = 0; i <= d1; i++) {
								R[x+i][y-i] = 5;
								R[x+d2+i][y+d2-i] = 5;
							}
							
							for (int i = 0; i <= d2; i++) {
								R[x+i][y+i] = 5;
								R[x+d1+i][y-d1+i] = 5;
							}
							
							for (int i = 1; i < x+d1; i++) {
								for (int j = 1; j <= y; j++) {
									if(R[i][j] == 5) {
										break;
									}
									R[i][j] = 1;
								}
							}
							
							for (int i = x+d2; i >= 1 ; i--) {
								for (int j = N; j >= y+1; j--) {
									if(R[i][j] == 5) {
										break;
									}
									R[i][j] = 2;
								}
							}
							
							for (int i = x+d1; i <= N; i++) {
								for (int j = 1; j <= y-d1+d2; j++) {
									if(R[i][j] == 5) {
										break;
									}
									R[i][j] = 3;
								}
							}
							
							for (int i = N; i >= x+d2+1; i--) {
								for (int j = N; j >= y-d1+d2; j--) {
									if(R[i][j] == 5) {
										break;
									}
									R[i][j] = 4;
								}
							}
							
							
							sum  = new int[6]; 
							for (int i = 1; i <= N; i++) {
								for (int j = 1; j <= N; j++) {
									if(R[i][j] == 1) {
										sum[1] += A[i][j];
									}else if(R[i][j] == 2) {
										sum[2] +=A[i][j];;
									}else if(R[i][j] == 3) {
										sum[3]+= A[i][j];;
									}else if(R[i][j] == 4) {
										sum[4]+= A[i][j];;
									}else {
										sum[5]+= A[i][j];;
									}
								}
							}
							int min = Integer.MAX_VALUE;
							int max = 0;
							for (int i = 1; i < 6; i++) {
								min = Math.min(min, sum[i]);
								max = Math.max(max, sum[i]);
							}
							ans = Math.min(ans, max-min);
						}
					}
				}

			}
		}
		System.out.println(ans);
	}
	
	static void init() {
		for (int i = 1; i <= N; i++) {
			Arrays.fill(R[i], 0);
		}
	}

}
