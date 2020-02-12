package algorithm.boj.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012_유기농배추 {

	static int M;
	static int N;
	static int K;
	static int[][] map;
	static boolean[][] visited;
	static int count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int m = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				map[n][m] = 1;
			}
			
			int res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 1) {
						count = 0;
						dfs(i,j);
						if(count > 0) {
							res++;
						}
					}
				}
			}
			System.out.println(res);
		}
		
	}

	static void dfs(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= M || map[x][y] == 0 || visited[x][y]) {
			return;
		}
		
		visited[x][y] = true;
		count++;
		
		dfs(x-1, y);
		dfs(x+1, y);
		dfs(x, y-1);
		dfs(x, y+1);
		
	}
}
