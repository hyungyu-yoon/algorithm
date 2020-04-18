package algorithm.boj.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7568_덩치 {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] height = new int[N];
		int[] weight = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			height[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			int count = 1;
			for (int j = 0; j < N; j++) {
				if(i == j) {
					continue;
				}
				
				if(height[i] < height[j] && weight[i] < weight[j]) {
					count++;
				}
			}
			System.out.print(count);
			if(i+1 < N) {
				System.out.print(" ");
			}
		}
		
	}

	
}
