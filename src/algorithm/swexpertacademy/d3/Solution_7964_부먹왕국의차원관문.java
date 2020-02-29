package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7964_부먹왕국의차원관문 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			int current = Integer.parseInt(st.nextToken());
			int sum = current == 0 ? 1 : 0;
			int count = 1;
			while (st.hasMoreTokens()) {
				current = Integer.parseInt(st.nextToken());
				
				if (current == 0 && count == D) {
					sum++;
					count = 0;
				} else if(current == 1) {
					count = 0;
				}
				
				count++;
			}

			System.out.println("#" + tc +" "+ sum);
		}
	}

}
