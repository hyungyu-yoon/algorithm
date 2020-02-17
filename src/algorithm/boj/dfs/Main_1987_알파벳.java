package algorithm.boj.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_알파벳 {

	static int R;
	static int C;
	static char[][] alpa;
	static boolean[] used;
	static int max;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		alpa = new char[R][C];
		used = new boolean[27];
		for (int i = 0; i < R; i++) {
			alpa[i] = br.readLine().toCharArray();
		}
		
		max = 0;
		dfs(0,0,0);
		System.out.println(max);
	}
	
	

	static void dfs(int x, int y, int c) {
		if(x < 0 || y < 0 || x >= R || y >= C || used[alpa[x][y] - 'A']) {
			max = Math.max(max, c);
			return;
		}
		
		used[alpa[x][y] - 'A'] = true;
		dfs(x+1,y,c+1);
		used[alpa[x][y] - 'A'] = false;
		
		used[alpa[x][y] - 'A'] = true;
		dfs(x,y+1,c+1);
		used[alpa[x][y] - 'A'] = false;
		
		used[alpa[x][y] - 'A'] = true;
		dfs(x-1,y,c+1);
		used[alpa[x][y] - 'A'] = false;
		
		used[alpa[x][y] - 'A'] = true;
		dfs(x,y-1,c+1);
		used[alpa[x][y] - 'A'] = false;
	}
}
