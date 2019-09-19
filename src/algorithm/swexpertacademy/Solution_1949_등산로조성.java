package algorithm.swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1949_등산로조성 {
	static int N;
	static int K;
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static boolean used;
	static boolean[][] visited;
	static int max;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			visited = new boolean[N][N];
			max = 0;
			ans = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] > max) {
						max = map[i][j];
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == max) {
						visited[i][j] = true;
						solve(i, j, 1, map[i][j]);
						visited[i][j] = false;
					}
				}
			}
			System.out.println("#" + tc + " " + ans);

		}
	}

	static public void solve(int x, int y, int sum, int h) {
		if (ans < sum) {
			ans = sum;
		}

		for (int i = 0; i < 4; i++) {
			int newX = x + dx[i];
			int newY = y + dy[i];
			if (newX < 0 || newY < 0 || newX >= N || newY >= N) {
				continue;
			}

			if(h <= map[newX][newY] && !used && !visited[newX][newY]) {
				if(map[newX][newY] - h < K) {
					used = true;
					visited[newX][newY] = true;
					solve(newX, newY, sum + 1, h-1);
					visited[newX][newY] = false;
					used = false;
				}
			}
			else if (h > map[newX][newY] && !visited[newX][newY]) {
				visited[newX][newY] = true;
				solve(newX, newY, sum + 1, map[newX][newY]);
				visited[newX][newY] = false;
			}
		}
	}
}
