package algorithm.boj.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2146_다리만들기 {

	static int N;
	static int[][] map;
	static int[][] bridge;
	static boolean[][] visited;
	static Queue<Point> list = new LinkedList();
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new boolean[N][N];

		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visited[i][j] || map[i][j] == 0) {
					continue;
				}
				dfs(i, j, num);
				num++;
			}
		}

		bfs();

		System.out.println(min);

	}

	static void dfs(int r, int c, int n) {
		visited[r][c] = true;
		map[r][c] = n;

		list.add(new Point(r, c));
		for (int i = 0; i < 4; i++) {
			int x = r + dx[i];
			int y = c + dy[i];

			if (x < 0 || y < 0 || x >= N || y >= N || visited[x][y] || map[x][y] == 0) {
				continue;
			}
			dfs(x, y, n);
		}
	}

	static void bfs() {
		bridge = new int[N][N];
		while (!list.isEmpty()) {
			Point p = list.poll();

			for (int i = 0; i < 4; i++) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				if (x < 0 || y < 0 || x >= N || y >= N) {
					continue;
				}

				if (map[x][y] == 0) {
					map[x][y] = map[p.x][p.y];
					bridge[x][y] = bridge[p.x][p.y] + 1;
					list.add(new Point(x,y));
				}else if(map[p.x][p.y] != map[x][y]) {
					min = Math.min(min,bridge[x][y] + bridge[p.x][p.y]);
				}
			}
			
		}

	}

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
