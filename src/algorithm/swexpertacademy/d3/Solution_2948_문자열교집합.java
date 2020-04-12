package algorithm.swexpertacademy.d3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
 
public class Solution_2948_문자열교집합 {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
         
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
				set.add(st.nextToken());
			}
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
				set.add(st.nextToken());
			}
            
            System.out.println("#" + tc + " " + (N+M-set.size()));
        }
    }
}