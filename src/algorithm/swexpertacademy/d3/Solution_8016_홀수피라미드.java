package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_8016_홀수피라미드 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			long N = Long.parseLong(br.readLine());
			
			long left = 1+ 2*(N-1)*N - 2*(N-1);
			long right = 1 + 2*(N-1)*N + 2*(N-1);

			System.out.println("#" + tc + " " + left + " " + right);
		}
	}
	
}
