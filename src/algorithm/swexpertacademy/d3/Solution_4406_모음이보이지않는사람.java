package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4406_모음이보이지않는사람 {
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			
			System.out.print("#" + tc + " ");
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (ch == 'a' || ch == 'i' || ch == 'o' || ch == 'e' || ch == 'u') {
					continue;
				}
				System.out.print(ch);
			}
			System.out.println();
		}
	}
	
}
