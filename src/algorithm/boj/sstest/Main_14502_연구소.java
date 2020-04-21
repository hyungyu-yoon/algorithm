package algorithm.boj.sstest;

import java.io.*;
import java.util.*;

public class Main_14502_연구소 {
	static int N, M;
	static int[][] lab;
	static int[][] temp;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		lab = new int[N][M];
		temp = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int len = N * M;
		for (int i = 0; i < len-2; i++) {
			if (lab[i / M][i % M] != 0) {
				continue;
			}
			lab[i / M][i % M] = 1;
			for (int j = i + 1; j < len - 1; j++) {
				if (lab[j / M][j % M] != 0) {
					continue;
				}
				lab[j / M][j % M] = 1;
				for (int k = j + 1; k < len; k++) {
					if (lab[k / M][k % M] != 0) {
						continue;
					}
					lab[k / M][k % M] = 1;
					solve();
					lab[k / M][k % M] = 0;
				}
				lab[j / M][j % M] = 0;
			}
			lab[i / M][i % M] = 0;
		}
		System.out.println(max);
	}

	static void solve() {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				temp[r][c] = lab[r][c];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (temp[i][j] != 2) {
					continue;
				}

				temp[i][j] = 0;
				dfs(i, j);
			}
		}

		int count = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (temp[r][c] == 0) {
					count++;
				}
			}
		}
		max = Math.max(max, count);
	}

	static void dfs(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= M || temp[r][c] != 0) {
			return;
		}

		temp[r][c] = 2;

		dfs(r + 1, c);
		dfs(r - 1, c);
		dfs(r, c + 1);
		dfs(r, c - 1);
	}
}
