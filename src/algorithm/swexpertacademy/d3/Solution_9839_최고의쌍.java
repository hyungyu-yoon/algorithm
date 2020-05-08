package algorithm.swexpertacademy.d3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_9839_최고의쌍 {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
         
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            
            int N = Integer.parseInt(br.readLine());
            int[] number = new int[N];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}
            
            int mul = 0;
            int max = -1;
            for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					mul = number[i]*number[j];
					if(!check(mul)) {
						continue;
					}
					
					
					max = Math.max(max, mul);
				}
			}
            System.out.println("#" +tc + " " + max);
        }
    }
    
    static boolean check(int number) {
    	int temp = number;
        int pre = number%10;
        temp /= 10;
    	while(temp > 0) {
    		if(pre - temp%10 != 1) {
    			return false;
    		}
    		pre = temp%10;
    		temp /= 10;
    	}
    	
    	return true;
    }
}