package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1289_원재의메모리복구하기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= t; test_case++) {
			String original = br.readLine();
			int count = 0;
			char temp = '0';
			for (int i = 0; i < original.length(); i++) {
				if (temp == '0' && original.charAt(i) == '1') {
					count++;
					temp = '1';
				} else if (temp == '1' && original.charAt(i) == '1') {
					continue;
				} else if (temp == '0' && original.charAt(i) == '0') {
					continue;
				} else {
					count++;
					temp = '0';
				}
			}

			System.out.println("#" + test_case + " " + count);
		}

	}
}