package algorithm.boj.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2667_단지번호붙이기 {

	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		visited = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray(); 
		}
		
		ArrayList<Integer> home = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == '1') {
					count = 0;
					dfs(i,j);
					if(count > 0) {
						home.add(count);
					}
				}
			}
		}
		
		Collections.sort(home);
		System.out.println(home.size());
		for (int i = 0; i < home.size(); i++) {
			System.out.println(home.get(i));
		}
		
	}

	static void dfs(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= N || map[x][y] == '0' || visited[x][y]) {
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
