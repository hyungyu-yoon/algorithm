package algorithm.swexpertacademy.swtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_2117_홈방범서비스2 {
	static int N;
	static int M;
	
	static int max;
	static ArrayList<Point> home;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			home = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					if(Integer.parseInt(st.nextToken()) == 1){
						home.add(new Point(i,j));
					}
				}
			}
			int[] dist = new int[2*N+1];
			max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (Point p : home) {
						int d = Math.abs(i-p.x)+Math.abs(j-p.y);
						dist[d]++;
					}
					int sum = 0;
					for (int k = 0; k < 2*N+1; k++) {
						if(dist[k] == 0) {
							continue;
						}
						
						sum+=dist[k];
						if(M*sum >= k*k + (k+1)*(k+1)) {
							max = Math.max(max, sum);
						}
						
						dist[k] = 0;
					}
				}
			}
			System.out.println("#" + tc+ " " + max);
			
		}
	}
	
	
	static class Point{
		int x;
		int y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
}
