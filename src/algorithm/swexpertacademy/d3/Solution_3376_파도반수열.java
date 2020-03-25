package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Solution_3376_파도반수열 {
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Long[] P = new Long[101];
		P[1] = 1L;
		P[2] = 1L;
		P[3] = 1L;
		P[4] = 2L;
		P[5] = 2L;
		for (int i = 6; i < P.length; i++) {
			P[i] = P[i-1] + P[i-5];
		}
				
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			System.out.println("#" +tc + " " + P[N]);
		}
	}
	
}
