package algorithm.swexpertacademy.d3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution_5215_햄버거다이어트 {
    static int max = 0;
    static int n;
    static int l;
    static int[] score;
    static int[] cal;
    static boolean[] used;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
             
            score = new int[n];
            cal = new int[n];
            used = new boolean[n];
             
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken());
                cal[i] = Integer.parseInt(st.nextToken());
            }
             
             
            find(0, 0,0);
            System.out.println("#" + tc +" "+ max);
            max = 0;
        }
    }
     
    static void find(int d, int sumScore,int sumCal) {
        if(sumCal > l) {
            return;
        }
        if(d == score.length) {
            if(sumCal <= l) {
                if(max < sumScore) {
                    max = sumScore;
                }
            }
            return;
        }
         
        used[d] = true;
        find(d+1,sumScore+score[d],sumCal + cal[d]);
        used[d] = false;
        find(d+1,sumScore, sumCal);
    }
 
}