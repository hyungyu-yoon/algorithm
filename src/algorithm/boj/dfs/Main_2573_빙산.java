package algorithm.boj.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2573_빙산 {

	static int N, M;
	static int[][] map;
	static boolean[][] used;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		used = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int res = 0;
		while (true) {
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0 || used[i][j]) {
						continue;
					}
					dfs(i, j);
					count++;
				}
			}
			
			if(count == 0) {
                System.out.println(0);
                break;
            } else if(count >= 2) {
                System.out.println(res);
                break;
            }
			
			used = new boolean[N][M];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 0) {
						continue;
					}

					for (int w = 0; w < 4; w++) {
						int r = i + dx[w];
						int c = j + dy[w];

						if (r < 0 || c < 0 || r >= N || c >= M || map[r][c] != 0 || used[r][c]) {
							continue;
						}
						map[i][j]--;
						if (map[i][j] == 0) {
							used[i][j] = true;
							break;
						}
					}

				}
			}
			res++;
			

		}

	}

	static void dfs(int i, int j) {
		if (i < 0 || j < 0 || i >= N || j >= M || map[i][j] == 0 || used[i][j]) {
			return;
		}

		used[i][j] = true;
		dfs(i + 1, j);
		dfs(i - 1, j);
		dfs(i, j + 1);
		dfs(i, j - 1);
	}

}
