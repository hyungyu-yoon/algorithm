package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_8500_극장좌석 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] A = new int[N];
			for (int i = 0; i < A.length; i++) {
				A[i] =  Integer.parseInt(st.nextToken());
			}
			Arrays.sort(A);
			
			int preNum = 0;
			int count = 0;
			int num = 0;
			for (int i = 0; i < N; i++) {
				num = A[i];
				
				if(preNum >= num) {
					count += preNum+1;
					preNum = num;
					continue;
				}
				
				count += num+1;
				preNum = num;
			}
			count += num;
			
			System.out.println("#" +tc + " " + count);
			
		}
	}
}
