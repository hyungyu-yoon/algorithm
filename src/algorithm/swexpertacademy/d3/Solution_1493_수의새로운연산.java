package algorithm.swexpertacademy.d3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_1493_수의새로운연산 {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int[] first = new int[500];
        int inc = 0;
        for (int i = 1; i < first.length; i++) {
            first[i] = (i)+ inc;
            inc += i-1;
        }
         
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
 
            int index = 0;
            while(first[index] <= p) {
                index++;
            }
             
            int x1 = (index-1)-(p - first[index-1]);
            int y1 = (1+p - first[index-1]);
             
            index = 0;
            while(first[index] <= q) {
                index++;
            }
            int x2 = (index-1)-(q - first[index-1]);
            int y2 = (1+q - first[index-1]);
             
            int s = first[x1+y1+x2+y2-1] + (y1+y2-1);
            System.out.println("#" + tc + " " + s);
        }
    }
}