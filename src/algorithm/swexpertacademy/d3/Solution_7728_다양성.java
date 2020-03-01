package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7728_다양성 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			
			boolean[] check = new boolean[10];
			for (int i = 0; i < str.length(); i++) {
				if(check[str.charAt(i) - '0']) {
					continue;
				}
				check[str.charAt(i) - '0'] = true;
			}
			
			int count = 0;
			for (int i = 0; i < check.length; i++) {
				if(check[i]) {
					count++;
				}
			}
			
			System.out.println("#"+tc+" " + count);
			
		}
	}
	
}
