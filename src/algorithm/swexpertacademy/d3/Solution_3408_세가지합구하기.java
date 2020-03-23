package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3408_세가지합구하기 {
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			long N = Long.parseLong(br.readLine());
			
			long S1 = (N+1)*N/2;
			long S3 = S1 * 2;
			long S2 = S3 - N;
			
			System.out.println("#" +tc + " " + S1 + " " + S2 + " " + S3);
		}
	}
	
}
