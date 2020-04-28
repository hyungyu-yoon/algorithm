package algorithm.boj.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1707_이분그래프 {

	static int V, E;
	public static ArrayList<ArrayList<Integer>> graph;
	static int[] visited;
	static String ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());
		for (int t = 0; t < K; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList<>();
			
			for (int j = 0; j < V; j++) {
				graph.add(new ArrayList<>());
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			
			ans = "YES";
			visited = new int[V];
			for (int i = 0; i < V; i++) {
				if(visited[i] == 0) {
					if(dfs(i,1)) {
						break;
					}
				}
			}
			System.out.println(ans);
		}

	}
	
	private static boolean dfs(int v, int c) {
		visited[v] = c;

		for (Integer i : graph.get(v)) {
			if (visited[i] == c) {
				ans = "NO";
				return true;
			}

			if (visited[i] == 0) {
				if (dfs(i, -c))
					return true;
			}
		}
		return false;
	}
}
