package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_3499_퍼펙트셔플 {
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String[] card = new String[N];
			
			for (int i = 0; i < N; i++) {
				card[i] = st.nextToken();
			}
			
			System.out.print("#" + tc + " ");
			if(N%2 == 0) {
				int len = N/2;
				for (int i = 0; i < len; i++) {
					System.out.print(card[i] + " " + card[i+len] + " ");
				}
			}else {
				int len = N/2 +1;
				for (int i = 0; i < len-1; i++) {
					System.out.print(card[i] + " " + card[i+len] + " ");
				}
				System.out.print(card[len - 1]);
			}
			System.out.println();
			
		}
	}
	
}
