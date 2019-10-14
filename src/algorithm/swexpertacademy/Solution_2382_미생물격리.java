package algorithm.swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2382_미생물격리 {
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			Cluster[] clusters = new Cluster[K];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				int way = Integer.parseInt(st.nextToken());
				
				clusters[i] = new Cluster(x, y, count, way);
			}
		
		}
	}
	
	
	
	static class Cluster{
		int x;
		int y;
		int count;
		int way;
		public Cluster(int x, int y, int count, int way) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
			this.way = way;
		}
		
	}
}
