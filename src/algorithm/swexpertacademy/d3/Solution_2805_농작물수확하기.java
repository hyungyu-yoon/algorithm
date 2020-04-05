package algorithm.swexpertacademy.d3;

import java.io.*;
import java.util.*;

public class Solution_2805_농작물수확하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			
			int[][] farm = new int[N][N];
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < N; j++) {
					farm[i][j] = str.charAt(j) - '0';
				}
			}
			
			int sum = 0;
            int mid = N/2;
            for (int i = 0; i <= mid; i++) {
                if(i == mid) {
                    for (int j = 0; j < farm.length; j++) {
                        sum += farm[i][j];
                    }
                    break;
                }
                else {
                    sum += farm[i][mid];
                    sum += farm[farm.length-1-i][mid];
                }
                 
                for (int j = 0; j < i; j++) {
                    sum += farm[i][mid+j+1] + farm[i][mid-j-1];
                    sum += farm[farm.length-1-i][mid+j+1] + farm[farm.length-1-i][mid-j-1];
                }
            }
            System.out.println("#" + tc +" " +  sum);
		}
	}
	
}
