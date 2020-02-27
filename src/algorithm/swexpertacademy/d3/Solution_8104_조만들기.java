package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_8104_조만들기 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] sumK = new int[K];
		
			boolean check = true;
			int num = 1;
			for (int i = 0; i < N; i++) {
				if(check) {
					for (int j = 0; j < K; j++) {
						sumK[j] += num++;
					}
					check = false;
				}else {
					for (int j = K-1; j >= 0; j--) {
						sumK[j] += num++;
					}
					check = true;
				}
				
			}
			
			System.out.print("#" + tc+ " ");
			for (int i = 0; i < sumK.length; i++) {
				System.out.print(sumK[i] + " ");
			}
			System.out.println();
		}
	}
	
}
