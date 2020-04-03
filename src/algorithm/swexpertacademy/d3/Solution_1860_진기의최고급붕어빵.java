package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_1860_진기의최고급붕어빵 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int[] p = new int[11112];
			for (int i = 0; i < N; i++) {
				p[Integer.parseInt(st.nextToken())]++;
			}
			
			boolean result = true;
			if(p[0] > 0) {
				System.out.println("#" + tc + " Impossible");
				continue;
			}
			int count = 0;
			for (int i = 1; i < 11112; i++) {
				if(i%M == 0) {
					count+=K;
				}
				
				count -= p[i];
				if(count < 0) {
					result = false;
					break;
				}
			}
			
			if(result) {
				System.out.println("#" + tc + " Possible");
			}else {
				System.out.println("#" + tc + " Impossible");
			}
			
		}
	}
	
}
