package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_7087_문제제목붙이기 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println((int)'Z' -'A');
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			boolean[] check = new boolean[26];
			
			for (int i = 0; i < N; i++) {
				char a = br.readLine().charAt(0);
				
				check[a - 'A']= true;
				
			}
			
			int count = 0;
			for (int i = 0; i < check.length; i++) {
				if(check[i]) {
					count++;
				}else {
					break;
				}
				
			}
			System.out.println("#" + tc+ " " + count);
			
		}
	}
	
}
