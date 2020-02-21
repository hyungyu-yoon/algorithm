package algorithm.boj.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10026_적록색약 {

	static int N;
	static char[][] color;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		color = new char[N][N];
		for (int i = 0; i < N; i++) {
			color[i] = br.readLine().toCharArray();
		}
		
		int count = 0; 
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visited[i][j]) {
					continue;
				}
				count++;
				dfs1(i,j,color[i][j]);
			}
		}
		
		System.out.print(count + " ");
		count = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(visited[i][j]) {
					continue;
				}
				count++;
				dfs2(i,j,color[i][j]);
			}
		}
		System.out.println(count);
		
	}

	static void dfs1(int x, int y, char currentColor) {
		if(x < 0 || y < 0 || x >= N || y >= N || color[x][y] != currentColor || visited[x][y] ) {
			return;
		}
		
		visited[x][y] = true;
		
		
		
		dfs1(x+1, y,currentColor);
		dfs1(x, y+1,currentColor);
		dfs1(x-1, y,currentColor);
		dfs1(x, y-1,currentColor);
	}
	
	static void dfs2(int x, int y, char currentColor) {
		if(x < 0 || y < 0 || x >= N || y >= N || visited[x][y] ) {
			return;
		}
		
		if(currentColor == 'R' || currentColor == 'G') {
			if(color[x][y] == 'B') {
				return;
			}
		}
		
		if(currentColor == 'B' && color[x][y] != 'B') {
			return;
		}
		
		visited[x][y] = true;
		
		
		dfs2(x+1, y,currentColor);
		dfs2(x, y+1,currentColor);
		dfs2(x-1, y,currentColor);
		dfs2(x, y-1,currentColor);
	}
}
