package algorithm.swexpertacademy.d4;
import java.io.*;
import java.util.*;
  
public class Solution_4050_재관이의대량할인 {
  
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
             
            int[] p = new int[n];
             
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int i = 0; i < n; i++) {
                p[i] = Integer.parseInt(st.nextToken());
                sum += p[i];
            }
             
            Arrays.sort(p);
            for (int i = n%3; i < p.length; i+=3) {
                sum -= p[i];
            }
            System.out.println("#" + tc + " " + sum);
             
             
        }
    }
      
    
}