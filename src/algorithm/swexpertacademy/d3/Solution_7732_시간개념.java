package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7732_시간개념 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String[] time = br.readLine().split(":"); 

			int[] time1 = new int[3];
			int[] time2 = new int[3];
			
			for (int i = 0; i < time.length; i++) {
				time1[i] = Integer.parseInt(time[i]);
			}
			
			time = br.readLine().split(":");
			for (int i = 0; i < time.length; i++) {
				time2[i] = Integer.parseInt(time[i]);
			}
			
			
			if(time2[2] >= time1[2]) {
				time[2] = time2[2] - time1[2] + "";
			}else {
				time[2] = 60 - time1[2] + time2[2] +"";
				time2[1]--;
			}
			
			if(time2[1] >= time1[1]) {
				time[1] = time2[1] - time1[1] + "";
			}else {
				time[1] = 60 - time1[1] + time2[1] +"";
				time2[0]--;
			}
			if(time2[0] >= time1[0]) {
				time[0] = time2[0] - time1[0] + "";
			}else {
				time[0] = 24 - time1[0] + time2[0] +"";
			}
			
			
			
			System.out.println("#" + tc + " " + (time[0].length() < 2 ? "0" + time[0] : time[0]) + ":" 
			+ (time[1].length() < 2 ? "0" + time[1] : time[1]) + ":" + (time[2].length() < 2 ? "0" + time[2] : time[2]));
			
		}
	}
	
}
