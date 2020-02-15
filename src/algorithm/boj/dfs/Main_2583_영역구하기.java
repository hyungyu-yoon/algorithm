package algorithm.boj.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2583_영역구하기 {
	static int M;
	static int N;
	static int K;
	static int[][] paper;
	static int c;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		paper = new int[M][N];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int lx = Integer.parseInt(st.nextToken());
			int ly = Integer.parseInt(st.nextToken());
			int rx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken());
			
			for (int j = lx; j < rx ; j++) {
				for (int k = ly; k < ry ; k++) {
					paper[k][j] = 1;
				}
			}
		}
		
		ArrayList<Integer> count = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(paper[i][j] == 1) {
					continue;
				}
				c = 0;
				dfs(i,j);
				count.add(c);
			}
		}
		Collections.sort(count);
		System.out.println(count.size());
		for (int i = 0; i < count.size(); i++) {
			System.out.print (count.get(i) + " ");
		}
		System.out.println();
		
	}

	static void dfs(int x, int y) {
		if(x < 0 || y < 0 || x >= M || y >= N || paper[x][y] == 1) {
			return;
		}
		
		paper[x][y] = 1; 
		c++;
		
		dfs(x+1,y);
		dfs(x,y+1);
		dfs(x-1,y);
		dfs(x,y-1);
	}
}
