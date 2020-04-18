package algorithm.boj.sstest;

import java.io.*;
import java.util.*;

public class Main_12100_2048Easy {
	static int N;
	static int[][] board;
	static int[] way = {1,2,3,4};
	static int[] order = new int[5];
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		board = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = 0;
		perm(0,5);
		System.out.println(max);
	}
	
	static void solve() {
		int[][] temp = new int[N][N];
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				temp[i][j] = board[i][j];
			}
		}
		for (int i = 0; i < order.length; i++) {
			switch (order[i]) {
			case 1:
				up(temp);
				break;
			case 2:
				down(temp);
				break;
			case 3:
				left(temp);
				break;
			case 4:
				right(temp);
				break;
			default:
				break;
			}
			
		}
		
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp.length; j++) {
				if(max < temp[i][j]) {
					max = temp[i][j];
				}
			}
		}
	}
	
	static void up(int[][] board) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = i+1; k < N; k++) {
					if(board[k][j] == 0) {
						continue;
					}
					
					if(board[i][j] == board[k][j]) {
						board[i][j]*= 2;
						board[k][j] = 0;
					}
					break;
				}
				
				int index = i;
				for (int k = i-1; k >= 0; k--) {
					if(board[k][j] == 0) {
						index = k;
					}else {
						break;
					}
				}
				if(index != i) {
					board[index][j] = board[i][j];
					board[i][j] = 0;
				}
			}
		}
	}
	
	static void down(int[][] board) {
		for (int i = N-1; i >= 0; i--) {
			for (int j = N-1; j >= 0; j--) {
				for (int k = i-1; k >= 0; k--) {
					if(board[k][j] == 0) {
						continue;
					}
					
					if(board[i][j] == board[k][j]) {
						board[i][j]*= 2;
						board[k][j] = 0;
					}
					break;
				}
				
				int index = i;
				for (int k = i+1; k < N; k++) {
					if(board[k][j] == 0) {
						index = k;
					}else {
						break;
					}
				}
				if(index != i) {
					board[index][j] = board[i][j];
					board[i][j] = 0;
				}
			}
		}
	}
	
	static void left(int[][] board) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = j+1; k < N; k++) {
					if(board[i][k] == 0) {
						continue;
					}
					
					if(board[i][j] == board[i][k]) {
						board[i][j]*= 2;
						board[i][k] = 0;
					}
					break;
				}
				
				int index = j;
				for (int k = j-1; k >= 0; k--) {
					if(board[i][k] == 0) {
						index = k;
					}else {
						break;
					}
				}
				if(index != j) {
					board[i][index] = board[i][j];
					board[i][j] = 0;
				}
			}
		}
	}
	
	static void right(int[][] board) {
		for (int i = N-1; i >= 0; i--) {
			for (int j = N-1; j >= 0; j--) {
				for (int k = j-1; k >= 0; k--) {
					if(board[i][k] == 0) {
						continue;
					}
					
					if(board[i][j] == board[i][k]) {
						board[i][j]*= 2;
						board[i][k] = 0;
					}
					break;
				}
				
				int index = j;
				for (int k = j+1; k < N; k++) {
					if(board[i][k] == 0) {
						index = k;
					}else {
						break;
					}
				}
				if(index != j) {
					board[i][index] = board[i][j];
					board[i][j] = 0;
				}
			}
		}
	}
	
	static void perm(int cnt, int r) {
		if(cnt == r) {
			solve();
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			order[cnt] = way[i];
			perm(cnt+1, r);
			order[cnt] = 0;
		}
	}
}
