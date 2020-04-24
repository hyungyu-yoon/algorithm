package algorithm.boj.sstest;

import java.io.*;
import java.util.*;

public class Main_14503_로봇청소기 {
	static int N,M;
	static int r,c,d;
	static int[][] map;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 북 0 동 1 남 2 서 3
		int count = 0;
		boolean exit;
		while(true) {
			count++;
			map[r][c] = 2;
			exit = true;
			
			
			if(d == 0) { // 북
				int w = 0;
				for (int i = 0; i < 4; i++) {
					w = w-1 < 0 ? 3 : w-1;
					int x = r + dx[w];
					int y = c + dy[w];
					
					if(map[x][y] != 0) {
						continue;
					}
					
					r = x;
					c = y;
					d = w;
					exit = false;
					break;
				}
			}else if(d == 1) { // 동
				int w = 1;
				for (int i = 0; i < 4; i++) {
					w = w-1 < 0 ? 3 : w-1; 
					int x = r + dx[w];
					int y = c + dy[w];
					
					if(map[x][y] != 0) {
						continue;
					}
					
					r = x;
					c = y;
					d = w;
					exit = false;
					break;
				}
			}else if(d == 2) { // 남
				int w = 2;
				for (int i = 0; i < 4; i++) {
					w = w-1 < 0 ? 3 : w-1; 
					int x = r + dx[w];
					int y = c + dy[w];
					
					if(map[x][y] != 0) {
						continue;
					}
					
					r = x;
					c = y;
					d = w;
					exit = false;
					break;
				}
			}else if(d == 3) { // 서
				int w = 3;
				for (int i = 0; i < 4; i++) {
					w = w-1 < 0 ? 3 : w-1; 
					int x = r + dx[w];
					int y = c + dy[w];
					
					if(map[x][y] != 0) {
						continue;
					}
					
					r = x;
					c = y;
					d = w;
					exit = false;
					break;
				}
			}
			
			if(exit) {
				if(d == 0) {
					int x = r + dx[2];
					int y = c + dy[2];
					
					if(map[x][y] == 2) {
						r = x;
						c = y;
						count--;
						continue;
					}
				}else if(d == 1) {
					int x = r + dx[3];
					int y = c + dy[3];
					
					if(map[x][y] == 2) {
						r = x;
						c = y;
						count--;
						continue;
					}
				}else if(d == 2) {
					int x = r + dx[0];
					int y = c + dy[0];
					
					if(map[x][y] == 2) {
						r = x;
						c = y;
						count--;
						continue;
					}
				}else if(d == 3) {
					int x = r + dx[1];
					int y = c + dy[1];
					
					if(map[x][y] == 2) {
						r = x;
						c = y;
						count--;
						continue;
					}
				}
				break;
			}
		}
		System.out.println(count);
	}
	
}
