package algorithm.boj.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_DFS와BFS {

	static int[][] graph;
	static int N,M,V;
	
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		visited = new boolean[N+1];
		dfs(0,V);
		System.out.println();
		visited = new boolean[N+1];
		bfs();
	}
	
	static void dfs(int d, int node) {
		if(d == N) {
			return;
		}
		
		if(visited[node]) {
			return;
		}
		System.out.print(node + " ");
		visited[node] = true;
		
		for (int i = 1; i <= N; i++) {
			if(graph[node][i] == 1) {
				dfs(d+1, i);
			}
		}
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(V);
		while(!q.isEmpty()) {
			int node = q.poll();
			
			if(visited[node]) {
				continue;
			}
			System.out.print(node + " ");
			visited[node] = true;
			for (int i = 1; i <= N; i++) {
				if(graph[node][i] == 1) {
					q.add(i);
				}
			}
		}
	}

}
