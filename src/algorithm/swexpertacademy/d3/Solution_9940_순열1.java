package algorithm.swexpertacademy.d3;

import java.io.*;
import java.util.*;

public class Solution_9940_순열1 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			boolean[] check = new boolean[N+1];
			String answer = "Yes";
			int num = 0;
			for (int i = 0; i < N; i++) {
				num = Integer.parseInt(st.nextToken());
				if(check[num]) {
					answer = "No";
					break;
				}
				check[num] = true;
			}
			
			System.out.println("#" +tc + " " + answer);
			
			
		}
	}
	
}
