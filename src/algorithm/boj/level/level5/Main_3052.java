package algorithm.boj.level.level5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_3052 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] count = new int[42];
		for (int i = 0; i < 10; i++) {
			count[Integer.parseInt(br.readLine())%42]++;
		}
		
		int res = 0;
		for (int i = 0; i < 42; i++) {
			if(count[i] > 0) {
				res++;
			}
		}
		System.out.println(res);
		
	}
}
