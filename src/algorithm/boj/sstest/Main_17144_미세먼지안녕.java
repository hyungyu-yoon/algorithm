package algorithm.boj.sstest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕 {
	static int[][] space;
	static Point[] air;
	static int R,C,T;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		space = new int[R][C];
		
		air = new Point[2];
		int index = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				
				space[i][j] = Integer.parseInt(st.nextToken());
				if(space[i][j] == -1) {
					air[index++] = new Point(i,j);
				}
			}
		}
		
		for (int k = 0; k < T; k++) {
			moveDust();
			clean();
		}
		
		int ans = 0;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(space[i][j] > 0) {
					ans += space[i][j];
				}
			}
		}
		System.out.println(ans);
	}
	
	static public void moveDust() {
		int[][] tmp = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(space[i][j] == -1) {
					continue;
				}
				int count = 4;
				int val = space[i][j]/5;
				
				for (int k = 0; k < 4; k++) {
					int x = i + dx[k];
					int y = j + dy[k];
					
					if(x < 0 || y < 0 || x >= R || y >= C || space[x][y] == -1) {
						count--;
						continue;
					}
					tmp[x][y] += val;
				}
				space[i][j] = space[i][j] - val*count;
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(tmp[i][j] != 0) {
					space[i][j] += tmp[i][j];
				}
			}
		}
	}
	
	static public void clean() {
		Point p = new Point(air[0].x,air[0].y+1);
		
		int way = 1;
		int val = space[p.x][p.y];
		space[p.x][p.y] = 0;
		while(space[p.x][p.y] != -1) {
			int tmp = 0;
			switch(way) {
			case 1:
				p.y++;
				if(p.y >= C) {
					p.y--;
					way = 2;
					break;
				}
				
				tmp = space[p.x][p.y];
				space[p.x][p.y] = val;
				val = tmp;
				break;
			case 2:
				p.x--;
				if(p.x < 0) {
					p.x++;
					way = 3;
					break;
				}
				
				tmp = space[p.x][p.y];
				space[p.x][p.y] = val;
				val = tmp;
				break;
			case 3:
				p.y--;
				if(p.y < 0) {
					p.y++;
					way = 4;
					break;
				}
				
				tmp = space[p.x][p.y];
				space[p.x][p.y] = val;
				val = tmp;
				break;
			case 4:
				p.x++;
				if(space[p.x][p.y] == -1) {
					break;
				}
				
				tmp = space[p.x][p.y];
				space[p.x][p.y] = val;
				val = tmp;
				break;
			}
			
		}
		p = new Point(air[1].x,air[1].y+1);
		
		way = 1;
		val = space[p.x][p.y];
		space[p.x][p.y] = 0;
		while(space[p.x][p.y] != -1) {
			int tmp = 0;
			switch(way) {
			case 1:
				p.y++;
				if(p.y >= C) {
					p.y--;
					way = 2;
					break;
				}
				
				tmp = space[p.x][p.y];
				space[p.x][p.y] = val;
				val = tmp;
				break;
			case 2:
				p.x++;
				if(p.x >= R) {
					p.x--;
					way = 3;
					break;
				}
				
				tmp = space[p.x][p.y];
				space[p.x][p.y] = val;
				val = tmp;
				break;
			case 3:
				p.y--;
				if(p.y < 0) {
					p.y++;
					way = 4;
					break;
				}
				
				tmp = space[p.x][p.y];
				space[p.x][p.y] = val;
				val = tmp;
				break;
			case 4:
				p.x--;
				if(space[p.x][p.y] == -1) {
					break;
				}
				
				tmp = space[p.x][p.y];
				space[p.x][p.y] = val;
				val = tmp;
				break;
			}
			
		}
		
	}
	
	
	static class Point{
		int x;
		int y;
		int val;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public Point(int x, int y, int val) {
			this.x = x;
			this.y = y;
			this.val = val;
		}
	}
}
