package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_8840_아바바바 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			Long L = Long.parseLong(br.readLine());
			
			long sum = 0;
			sum = ((L-1)/2)*((L-1)/2);
			System.out.println("#" + tc +" " + sum);
		}
	}
}
