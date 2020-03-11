package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_7227_사랑의카운슬러 {
    static Point[] points;
    static boolean[] vistied;
    static long min;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
             
            points = new Point[n];
            vistied = new boolean[n];
            min = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                points[i] = new Point(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }
             
            dfs(0,0);
            System.out.println("#"+ tc+ " " +min);
        }
    }
     
    static void dfs(int d, int c) {
        if(c == points.length/2) {
            long x = 0L; 
            long y = 0L;
            for (int i = 0; i < points.length; i++) {
                if(!vistied[i]) {
                    x += points[i].x;
                    y += points[i].y;
                }
                else {
                    x -= points[i].x;
                    y -= points[i].y;
                }
            }
             
            min = Math.min(min, x*x+y*y);
            return;
        }
         
         
        for (int i = d; i < points.length; i++) {
            if(!vistied[i]) {
                vistied[i] = true;
                dfs(i+1,c+1);
                vistied[i] = false;
            }
        }
    }
     
    static class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
 
}