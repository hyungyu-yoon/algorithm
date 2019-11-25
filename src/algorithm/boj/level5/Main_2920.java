package algorithm.boj.level5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2920 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		boolean check = true;
		if(n == 1) {
			for (int i = 2; i <= 8; i++) {
				if(i != Integer.parseInt(st.nextToken())) {
					check = false;
					break;
				}
			}
			
			if(check) {
				System.out.println("ascending");
			}else {
				System.out.println("mixed");
			}
		}else if(n == 8) {
			for (int i = 7; i >= 1; i--) {
				if(i != Integer.parseInt(st.nextToken())) {
					check = false;
					break;
				}
			}
			
			if(check) {
				System.out.println("descending");
			}else {
				System.out.println("mixed");
			}
		}else {
			System.out.println("mixed");
		}
	}
}
