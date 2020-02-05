package algorithm.swexpertacademy.swtest;

import java.io.*;
import java.util.*;
   
public class Solution_4013_특이한자석 {
    static ArrayList<Integer>[] mag;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int K = Integer.parseInt(br.readLine());
           mag = new ArrayList[5];
            StringTokenizer st = null;
            for (int i = 1; i <= 4; i++) {
                st = new StringTokenizer(br.readLine());
                mag[i] = new ArrayList<>();
                for (int j = 0; j < 8; j++) {
                    mag[i].add(Integer.parseInt(st.nextToken()));
                }
            }
              
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                int rot = Integer.parseInt(st.nextToken());
                  
                rotate(num, rot,0);
            }
            int score = 0;
            for (int i = 0; i <= 3; i++) {
                if(mag[i+1].get(0) == 1) {
                    score += Math.pow(2, i);
                }
            }
            System.out.println("#" + tc + " " + score);
        }
    }
      
    static void rotate(int num, int rot,int way) {
          
        int left = num-1;
        int right  = num+1;
          
        if(way != 2 && left >= 1 && mag[num].get(6) != mag[left].get(2)) {
            rotate(left, rot*-1,1);
        }
          
        if(way != 1 && right <= 4 && mag[num].get(2) != mag[right].get(6)) {
            rotate(right, rot*-1,2);
        }
          
        if(rot == 1) {
            mag[num].add(0,mag[num].remove(7));
        }else {
            mag[num].add(mag[num].remove(0));
        }
    }
       
     
}