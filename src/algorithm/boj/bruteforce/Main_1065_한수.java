package algorithm.boj.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1065_한수 {

	static int N;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		if(N < 100) {
			System.out.println(N);
		}else {
			int count = 99;
			for (int i = 100; i <= N; i++) {
				int num = i;
				int a = num/100;
				int b = (num/10)%10;
				int c = i%10;

				if(a - b == b - c) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

	
}
