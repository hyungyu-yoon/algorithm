package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_9997_미니멀리즘시계 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			int N = Integer.parseInt(br.readLine());
			
			int h = N/30;
			int m = N%30*2;
			
			System.out.println("#" +test_case + " " + h + " " + m );
			
		}

	}
}