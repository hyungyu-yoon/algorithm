package algorithm.boj.level8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2292 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		int val = 1;
		while(true) {
			val += count*6;
			if(N <= val) {
				break;
			}
			count++;
		}
		System.out.println(count+1);
	}
}
