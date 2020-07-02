package algorithm.swexpertacademy.d3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_1206_View {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
         
        for (int tc = 1; tc <= 10; tc++) {
        	int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] buildings = new int[N];
            
            for (int i = 0; i < N; i++) {
				buildings[i] = Integer.parseInt(st.nextToken());
			}
            
            int max = 0;
            int sum = 0;
            for (int i = 2; i < N-2; i++) {
            	max = 0;
				for (int j = 1; j <= 2; j++) {
					max = Math.max(max, buildings[i+j]);
					max = Math.max(max, buildings[i-j]);
				}
				
				if(buildings[i] > max) {
					sum += buildings[i] - max;
				}
			}
            System.out.println("#" +tc + " " + sum);
        }
    }
}