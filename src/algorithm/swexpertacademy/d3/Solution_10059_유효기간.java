package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_10059_유효기간 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			
			int a = Integer.parseInt(str.substring(0, 2));
			int b = Integer.parseInt(str.substring(2, 4));

			if((a > 12 && b > 12) || (a == 0 && b == 0) || (a > 12 && b == 0) || (a == 0 && b > 12)) {
				System.out.println("#" + tc + " NA");
			}else if(a > 0 && a <= 12 && (b > 12 || b == 0)) {
				System.out.println("#" + tc + " MMYY");
			}else if(b > 0 && b <= 12 && (a > 12 || a == 0)) {
				System.out.println("#" + tc + " YYMM");
			}else {
				System.out.println("#" + tc + " AMBIGUOUS");
			}
			
			
		}
	}
	
}
