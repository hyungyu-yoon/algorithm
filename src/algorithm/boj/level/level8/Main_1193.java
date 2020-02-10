package algorithm.boj.level.level8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1193 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int a = 1;
		int b = 1;
		int way = 0;
		for (int i = 1; i < N; i++) {
			if(a % 2 == 0 && b == 1) {
				a++;
				way = 0;
			}else if(b % 2 == 1 && a == 1) {
				b++;
				way = 1;
			}else if(way == 1) {
				a++;
				b--;
			}else if(way == 0) {
				a--;
				b++;
			}
		}
		System.out.println(a+"/"+b);
	}
}
