package algorithm.boj.sstest;

import java.io.*;
import java.util.*;

public class Main_3190_뱀 {
	static int N,K,L,X;
	static int[][] board;
	
	static int[] time;
	static char[] way;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		board = new int[N+2][N+2];
		StringTokenizer st = null;
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			board[r][c] = 1;
		}
		
		L = Integer.parseInt(br.readLine());
		time = new int[L];
		way = new char[L];
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			time[i] = x;
			way[i] = c;
		}
		
		int index = 0;
		int w = 3; // 위 0 아래1 왼2 오 3
		int hx = 1;
		int hy = 1;
		int tx = 1;
		int ty = 1;
		board[hx][hy] = 2;
		ArrayList<Integer> history = new ArrayList<>();
		int ans = 0;
		for (int t = 1; t <= 10000 ; t++) {
			hx += dx[w];
			hy += dy[w];
			
			if(board[hx][hy] == 2 || hx == 0 || hy == 0 || hx == N+1 || hy == N+1) {
				ans = t;
				break;
			}
			
			history.add(w);
			
			if(board[hx][hy] == 0){
				board[tx][ty] = 0;
				tx += dx[history.get(0)];
				ty += dy[history.remove(0)];
			}
			
			board[hx][hy] = 2;
			
			if(index < L && time[index] == t) {
				char c = way[index];
				if(w == 0) {
					w = c == 'D' ? 3 : 2;
				}else if(w == 1) {
					w = c == 'D' ? 2 : 3;
				}else if(w == 2) {
					w = c == 'D' ?  0: 1;
				}else {
					w = c == 'D' ? 1 : 0;
				}
				index++;
			}
			
		}
		System.out.println(ans);
	}
	
}
