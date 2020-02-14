package algorithm.boj.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11724_연결요소의개수 {

	static int N;
	static int M;
	static int[][] graph;
	static boolean[] used; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		int count = 0;
		used = new boolean[N+1];
		for (int i = 1; i <= N; i++) {
			if(!used[i]) {
				count++;
				used[i] = true;
				dfs(i);
			}
		}
		
		System.out.println(count);
		
	}

	static void dfs(int c) {
		
		for (int i = 1; i <= N; i++) {
			if(graph[c][i] == 1 && !used[i]) {
				used[i] = true;
				dfs(i);
			}
		}
		
	}
}
