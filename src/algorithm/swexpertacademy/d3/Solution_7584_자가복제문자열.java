package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_7584_자가복제문자열 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			Long K = Long.parseLong(br.readLine()) - 1;
			
			int result = 0;
			while(K > 0) {
				if(K%2 == 1) K = (K-1)/2;
				if(K%4 == 0) {result = 0; break;}
				else if(K%2 == 0) {result = 1; break;}
			}
			System.out.println("#" + tc+ " " + result);
		}
	}
	
}
