package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_8673_코딩토너먼트1 {
	
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = (int)Math.pow(2, N);
			int[] A = new int[N];
			for (int i = 0; i < A.length; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			
			result = 0;
			solve(A, N/2);
			System.out.println("#" + tc +" " +result);
		}
	}
	
	static void solve(int[] A, int N) {
		if(N == 0) {
			return;
		}
		
		int[] newA = new int[N];
		for (int i = 0; i < A.length; i+=2) {
			newA[i/2] = Math.max(A[i], A[i+1]);
			result += Math.abs(A[i] - A[i+1]);
		}
		
		solve(newA, N/2);
		
	}

}
