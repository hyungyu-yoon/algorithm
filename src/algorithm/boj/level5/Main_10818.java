package algorithm.boj.level5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10818 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			int n = Integer.parseInt(st.nextToken());
			
			if(min > n) {
				min = n;
			}
			
			if(max < n) {
				max = n;
			}
		}
		
		System.out.println(min + " " + max);
		
	}
}
