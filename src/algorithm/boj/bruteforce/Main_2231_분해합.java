package algorithm.boj.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2231_분해합 {
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int size = String.valueOf(N).length(); 
        int start = N - (9 * size); 
        int ans = 0;
        
        for(int i=start; i<N; i++) {
            int sum = i; 
            int num = i; 
            while(num > 0) {
                sum += num%10;
                num /= 10;
            }
            
            if(sum == N) {
                ans = i;
                break;
            }
        }
        System.out.println(ans);
	}
}
