package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4299_태혁이의사랑은타이밍 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int D = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int dTime = 11*24*60 + 11*60 + 11;
			int windTime = D*24*60 + H*60 + M;
			
			int res = 0;
			if(dTime < windTime) {
				res = windTime - dTime;
			}else if(dTime == windTime) {
				res = 0;
			}else {
				res = -1;
			}
			
			System.out.println("#" + tc + " "+ res);
		}
	}
	
}
