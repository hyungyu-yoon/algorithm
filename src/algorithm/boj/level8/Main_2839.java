package algorithm.boj.level8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2839 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		while(N > 0) {
			if(N % 5 == 0) {
				N -= 5;
				count++;
			}else if(N % 3 == 0) {
				N -= 3;
				count++;
			}else if(N > 5) {
				N -= 5;
				count++;
			}else {
				count = -1;
				break;
			}
		}
		System.out.println(count);
		
	}
}
