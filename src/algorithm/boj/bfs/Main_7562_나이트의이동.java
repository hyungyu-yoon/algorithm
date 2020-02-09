package algorithm.boj.bfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562_나이트의이동 {
	
	static int[] dx = {-2,-2,-1,-1,1,1,2,2};
	static int[] dy = {-1,1,-2,2,-2,2,-1,1};
	
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int l = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			Point start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),0);
			
			st = new StringTokenizer(br.readLine());
			Point end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),0);
			
			visited = new boolean[l][l];
			
			Queue<Point> q = new LinkedList<>();
			q.add(start);
			int count = 0;
			while(!q.isEmpty()) {
				Point knight = q.poll();
				if(knight.x == end.x && knight.y == end.y) {
					count = knight.c;
					break;
				}
				
				if(visited[knight.x][knight.y]) {
					continue;
				}
				
				visited[knight.x][knight.y] = true;
				
				for (int j = 0; j < 8; j++) {
					int newx = knight.x + dx[j];
					int newy = knight.y + dy[j];
					
					if(newx < 0 || newy < 0 || newx >= l || newy >= l || visited[newx][newy]) {
						continue;
					}
					
					q.add(new Point(newx,newy, knight.c+1));
				}
			}
			System.out.println(count);
		}
		
	}
	
	static class Point {
		int x,y,c;
		Point(int x, int y,int c){
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
}
