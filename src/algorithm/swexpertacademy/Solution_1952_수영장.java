package algorithm.swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952_수영장 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] money = new int[4];
            for (int i = 0; i < 4; i++) {
                money[i] = Integer.parseInt(st.nextToken());
 
            }
            st = new StringTokenizer(br.readLine());
            int[] plan = new int[14];
            for (int i = 0; i < 12; i++) {
                plan[i] = Math.min(Integer.parseInt(st.nextToken()) * money[0], money[1]);
            }
 
            for (int i = 10; i >= 0; i--) {
                plan[i] = Math.min(plan[i] + plan[i + 1], money[2] + plan[i + 3]);
            }
 
            int ans = Math.min(plan[0], money[3]);
 
            System.out.println("#" + tc + " " + ans);
		}
	}
}
