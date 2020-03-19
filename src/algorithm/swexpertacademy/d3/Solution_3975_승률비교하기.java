package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_3975_승률비교하기 {
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			double A = Double.parseDouble(st.nextToken());
			double B = Double.parseDouble(st.nextToken());
			double C = Double.parseDouble(st.nextToken());
			double D = Double.parseDouble(st.nextToken());
			
			String res = null;
			if(A/B == C/D) {
				res = "DRAW";
			}else if(A/B > C/D) {
				res = "ALICE";
			}else {
				res = "BOB";
			}
			System.out.println("#" + tc + " " + res);
		}
	}
	
}
