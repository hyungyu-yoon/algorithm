package algorithm.swexpertacademy.swtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거 {
	static int N;
	static int M;
	static int R;
	static int C;
	static int L;
	static int[][] space;
	static boolean[][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			space = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					space[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			Queue<Point> q = new LinkedList<>();
			q.add(new Point(R,C,L-1));
			visited[R][C] = true;
			while(!q.isEmpty()) {
				Point p = q.poll();
				if(p.l == 0) {
					continue;
				}
				
				int x = 0;
				int y = 0;
				int l = 0;
				int r = 0;
				int c = 0;
				switch (space[p.x][p.y]) {
				case 1:
					l = 0;
					r = 4;
					c = 1;
					break;
				case 2:
					l = 2;
					r = 4;
					c = 1;
					break;
				case 3:
					l = 0;
					r = 2;
					c = 1;
					break;
				case 4:
					l = 1;
					r = 3;
					c = 1;
					break;
				case 5:
					l = 1;
					r = 4;
					c = 2;
					
					break;
				case 6:
					l = 0;
					r = 4;
					c = 3;
					break;
				case 7:
					l = 0;
					r = 3;
					c = 2;
					break;
				}
				
				for (int i = l; i < r; i+=c) {
					x = p.x + dx[i];
					y = p.y + dy[i];
					
					if(x < 0 || y < 0 || x >= N || y >= M || space[x][y] == 0 || visited[x][y] || !check(i,space[x][y])) {
						continue;
					}
					
					visited[x][y] = true;
					q.add(new Point(x,y,p.l-1));
				}
			}
			
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(visited[i][j]) {
						count++;
					}
				}
			}
			
			
			System.out.println("#" + tc + " " + count);
		}
	}

	static public boolean check(int way, int type) {
		boolean result = false;
		switch (way) {
		case 0:
			if(type == 1 || type == 3 || type == 4 || type == 5) {
				result = true;
			}
			break;
		case 1:
			if(type == 1 || type == 3 || type == 6 || type == 7) {
				result = true;
			}
			break;
		case 2:
			if(type == 1 || type == 2 || type == 5 || type == 6) {
				result = true;
			}
			break;
		case 3:
			if(type == 1 || type == 2 || type == 4 || type == 7) {
				result = true;
			}
			break;
		default:
			break;
		}
		
		return result;
	}
	
	static class Point{
		int x;
		int y;
		int l;
		Point(int x, int y, int l){
			this.x = x;
			this.y = y;
			this.l = l;
		}
	}
}
