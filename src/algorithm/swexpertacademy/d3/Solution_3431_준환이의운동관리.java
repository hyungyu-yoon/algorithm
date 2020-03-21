package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3431_준환이의운동관리 {
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int L = Integer.parseInt(st.nextToken());
			int U = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			
			if(X > U) {
				System.out.println("#" +tc+ " " + "-1");
			}else if(X < L) {
				System.out.println("#" +tc+ " " + (L-X));
			}else {
				System.out.println("#" +tc + " " + "0");
			}
			
		}
	}
	
}
