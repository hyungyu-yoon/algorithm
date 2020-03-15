package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_4371_항구에들어오는배 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			int[] day = new int[N];

			for (int i = 0; i < N; i++) {
				day[i] = Integer.parseInt(br.readLine());
			}

			for (int i = 1; i < N; i++) {
				if (day[i] < 0)
					continue;
				int interval1 = day[i] - 1;
				for (int j = i + 1; j < N; j++) {
					if (day[j] < 0)
						continue;
					int interval2 = day[j] - 1;
					if (interval2 % interval1 == 0) {
						day[j] = -1;
					}
				}
			}
			int count = 0;
			for (int i = 1; i < N; i++) {
				if (day[i] > 0)
					count++;
			}

			System.out.println("#" + tc + " " + count);
		}
	}

}
