package algorithm.swexpertacademy.swtest;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_2382_미생물격리 {
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			Cluster[] clusters = new Cluster[K];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				int way = Integer.parseInt(st.nextToken());
				clusters[i] = new Cluster(x, y, count, way-1);
			}
			
			ArrayList<Integer>[][] map = new ArrayList[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = new ArrayList<Integer>();
				}
			}
			
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < K; j++) {
					if(clusters[j] == null) {
						continue;
					}
					
					int x = clusters[j].x + dx[clusters[j].way];
					int y = clusters[j].y + dy[clusters[j].way];
					
					if(x == 0) {
						clusters[j].way = 1;
						clusters[j].count /= 2;
					}else if(x == N-1) {
						clusters[j].way = 0;
						clusters[j].count /= 2;
					}else if(y == 0) {
						clusters[j].way = 3;
						clusters[j].count /= 2;
					}else if(y == N-1) {
						clusters[j].way = 2;
						clusters[j].count /= 2;
					}
					
					clusters[j].x = x;
					clusters[j].y = y;
					if(clusters[j].count == 0) {
						clusters[j] = null;
					}
					
					map[x][y].add(j);
				}
				
				for (int j = 1; j < N-1; j++) {
					for (int k = 1; k < N-1; k++) {
						if(map[j][k].size() == 0) {
							continue;
						}
						
						int sum = 0;
						int index = 0;
						int max = 0;
						for (int l = 0; l < map[j][k].size(); l++) {
							sum += clusters[map[j][k].get(l)].count;
							if(max < clusters[map[j][k].get(l)].count) {
								max = clusters[map[j][k].get(l)].count;
								index = map[j][k].get(l);
							}
						}
						
						clusters[index].count = sum;
						for (int l = 0; l < map[j][k].size(); l++) {
							if(map[j][k].get(l) == index) {
								continue;
							}
							clusters[map[j][k].get(l)] = null;
						}
						
						map[j][k].clear();
					}
				}
			}
			
			int sum = 0;
			for (int j = 0; j < K; j++) {
				if(clusters[j] == null) {
					continue;
				}
				sum += clusters[j].count;
			}
		
			System.out.println("#" + tc + " " + sum);
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
		
		@Override
		public String toString() {
			return x + " " + y + " " + count + " " + way;
		}
		
	}
}
