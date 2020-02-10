package algorithm.boj.level.level5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2577 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int mul = Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine());
		int[] count = new int[10];
		
		while(mul/10 != 0 || mul%10 != 0) {
			count[mul%10]++;
			mul /= 10;
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(count[i]);
		}
	}
}
