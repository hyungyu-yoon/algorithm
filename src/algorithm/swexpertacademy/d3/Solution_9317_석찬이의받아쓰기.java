package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_9317_석찬이의받아쓰기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			String str1 = br.readLine();
			String str2 = br.readLine();
			int count = 0;
			for (int i = 0; i < N; i++) {
				if(str1.charAt(i) == str2.charAt(i)) {
					count++;
				}
			}
			System.out.println("#" + tc+ " " + count);
		}
	}

}
