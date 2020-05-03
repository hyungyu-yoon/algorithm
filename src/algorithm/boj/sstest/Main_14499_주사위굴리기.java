package algorithm.boj.sstest;

import java.io.*;
import java.util.*;

public class Main_14499_주사위굴리기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dice = new int[6];
		int[] temp = new int[6];
		int[][] direct = { 
			{ 2, 1, 5, 0, 4, 3 }, 
			{ 3, 1, 0, 5, 4, 2 }, 
			{ 4, 0, 2, 3, 5, 1 }, 
			{ 1, 5, 2, 3, 0, 4 } 
		};

		int[] dx = { 0, 0, -1, 1 };
		int[] dy = { 1, -1, 0, 0 };
		st = new StringTokenizer(br.readLine());

		while (st.hasMoreTokens()) {
			int way = Integer.parseInt(st.nextToken()) - 1;
			x += dx[way];
			y += dy[way];
			if (x < 0 || x >= N || y < 0 || y >= M) {
				x -= dx[way];
				y -= dy[way];
				continue;
			}
			
			for (int i = 0; i < 6; i++) {
				temp[i] = dice[i];
			}
			
			for (int i=0; i<6; i++) {
	            dice[i] = temp[direct[way][i]];
	        }
			
	        if (map[x][y] != 0) {
	            dice[5] = map[x][y];
	            map[x][y] = 0;
	        } else {
	            map[x][y] = dice[5];
	        }

	        System.out.println(dice[0]);
		}

	}
}
