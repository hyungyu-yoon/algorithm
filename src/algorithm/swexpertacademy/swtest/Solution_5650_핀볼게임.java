package algorithm.swexpertacademy.swtest;

import java.io.*;
import java.util.*;

public class Solution_5650_핀볼게임 {
	static int N;
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 }; // 왼 0 오 1 위 2 아래 3

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != 0) {
						continue;
					}
					for (int w = 0; w < 4; w++) {
						int count = move(i, j, w);
						max = Math.max(max, count);
					}
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}

	private static int move(int i, int j, int w) {
		int x = i;
		int y = j;
		int count = 0;
		while (true) {
			x += dx[w];
			y += dy[w];
			if (x < 0) {
				w = 3;
				count++;
				return count * 2 - 1;
			} else if (x >= N) {
				w = 2;
				count++;
				return count * 2 - 1;
			} else if (y < 0) {
				w = 1;
				count++;
				return count * 2 - 1;
			} else if (y >= N) {
				w = 0;
				count++;
				return count * 2 - 1;
			} else if (map[x][y] == -1) {
				break;
			} else if (map[x][y] >= 1 && map[x][y] <= 5) {
				w = rotate(map[x][y], w);
				count++;
			} else if (map[x][y] >= 6 && map[x][y] <= 10) {
				for (int k = 0; k < N; k++) {
					for (int k2 = 0; k2 < N; k2++) {
						if (map[x][y] == map[k][k2] && (x != k || y != k2)) {
							x = k;
							y = k2;
							k = N;
							break;
						}
					}
				}
			}
			if (x == i && y == j) {
				break;
			}
		}
		return count;
	}

	static int rotate(int block, int way) {
		int w = 0;
		if (block == 1) {
			if (way == 0) {
				w = 2;
			} else if (way == 1) {
				w = 0;
			} else if (way == 2) {
				w = 3;
			} else {
				w = 1;
			}
		} else if (block == 2) {// 왼 0 오 1 위 2 아래 3
			if (way == 0) {
				w = 3;
			} else if (way == 1) {
				w = 0;
			} else if (way == 2) {
				w = 1;
			} else {
				w = 2;
			}
		} else if (block == 3) {
			if (way == 0) {
				w = 1;
			} else if (way == 1) {
				w = 3;
			} else if (way == 2) {
				w = 0;
			} else {
				w = 2;
			}
		} else if (block == 4) {
			if (way == 0) {
				w = 1;
			} else if (way == 1) {
				w = 2;
			} else if (way == 2) {
				w = 3;
			} else {
				w = 0;
			}
		} else {
			if (way == 0) {
				w = 1;
			} else if (way == 1) {
				w = 0;
			} else if (way == 2) {
				w = 3;
			} else {
				w = 2;
			}
		}
		return w;
	}
}