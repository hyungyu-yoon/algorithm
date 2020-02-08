package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_8821_적고지우기 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			
			boolean[] list = new boolean[10];
			
			for (int i = 0; i < str.length(); i++) {
				int num = str.charAt(i) - '0';
				list[num] = list[num] ? false : true;
			}
			
			int count = 0;
			for (int i = 0; i < list.length; i++) {
				count = list[i] ? ++count : count;
			}
			System.out.println("#" + tc+ " " + count );
		}
	}

}
