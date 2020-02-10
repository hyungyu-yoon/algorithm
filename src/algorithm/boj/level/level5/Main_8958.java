package algorithm.boj.level.level5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_8958 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			int score = 0;
			int count = 1;
			for (int j = 0; j < str.length(); j++) {
				if(str.charAt(j) == 'O') {
					score += count++;
				}else {
					count = 1;
				}
			}
			System.out.println(score);
		}
		
	}
}
