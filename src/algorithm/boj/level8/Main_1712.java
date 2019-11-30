package algorithm.boj.level8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1712 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		
		if(B >= C) {
			System.out.println(-1);
		}else {
			int count = 1;
			while(true) {
				if(A+B*count < C*count) {
					break;
				}
				count++;
			}
			System.out.println(count);
		}
		
		
	}
}
