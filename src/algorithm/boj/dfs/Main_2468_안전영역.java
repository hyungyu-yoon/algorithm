package algorithm.boj.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {

	static int N;
	static int[][] space;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		space = new int[N][N];
		
		StringTokenizer st = null;
		int max = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				space[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(space[i][j], max);
			}
		}
		
		int count;
		int result = 1;
		for (int h = 1; h < max; h++) {
			visited = new boolean[N][N];
			count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(visited[i][j] || space[i][j] <= h) {
						continue;
					}
					count++;
					dfs(i,j,h);
				}
			}
			result = Math.max(result, count);
		}
		
		System.out.println(result);
	}

	static void dfs(int x, int y, int h) {
		if(x < 0 || y < 0 || x >= N || y >= N || space[x][y] <= h || visited[x][y]) {
			return;
		}
		
		visited[x][y] = true;
		
		dfs(x+1,y,h);
		dfs(x,y+1,h);
		dfs(x-1,y,h);
		dfs(x,y-1,h);
	}
}
