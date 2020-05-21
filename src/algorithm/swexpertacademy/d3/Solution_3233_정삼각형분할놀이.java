package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3233_정삼각형분할놀이 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			Long A = Long.parseLong(st.nextToken());
			Long B = Long.parseLong(st.nextToken());
		
			long AB = A/B;
			
			System.out.println("#" + test_case + " " + AB*AB);
		
		}

	}
}