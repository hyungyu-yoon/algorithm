package algorithm.swexpertacademy.swtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2112_보호필름 {
	static int D;
	static int W;
	static int K;
	static int[][] film;
	static int[][] temp;
	static int min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			film = new int[D][W];
			temp = new int[D][W];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
					temp[i][j] = film[i][j];
				}
			}
			
			min = Integer.MAX_VALUE;
			dfs(0,0);
			
			System.out.println("#" + tc+ " " + min);
		}
	}
	
	static public boolean check(int y) {
		int count = 1;
		int num = film[0][y];
		for (int i = 1; i < film.length; i++) {
			if(film[i][y] == num) {
				count++;
			}else {
				if(count >= K) {
					return true;
				}
				count = 1;
				num = film[i][y];
			}
		}
		if(count >= K) {
			return true;
		}else {
			return false;
		}
	}
	
	static public void dfs(int d, int c) {
		if(min < c) {
			return;
		}
		
		if(d == D) {
			for (int i = 0; i < W; i++) {
				if(!check(i)) {
					return;
				}
			}
			
			min = Math.min(min, c);
			
			
			return;
		}
		
		dfs(d+1,c);
		
		Arrays.fill(film[d], 0);
		dfs(d+1,c+1);
		
		Arrays.fill(film[d], 1);
		dfs(d+1,c+1);
		film[d] = Arrays.copyOf(temp[d], W);
	}
	
}
