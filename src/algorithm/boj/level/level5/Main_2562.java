package algorithm.boj.level.level5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2562 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int max = 0;
		int index = 0;
		for (int i = 1; i <= 9; i++) {
			int num = Integer.parseInt(br.readLine());
			if(max < num) {
				max = num;
				index = i;
			}
		}
		System.out.println(max);
		System.out.println(index);
	}
}
