package algorithm.boj.sstest;

import java.io.*;
import java.util.*;

public class Main_13458_시험감독 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] testSite = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			testSite[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		long sum = N;

		for (int i = 0; i < testSite.length; i++) {
			testSite[i] -= B;

			if (testSite[i] > 0) {

				if (testSite[i] % C == 0) {
					sum += testSite[i] / C;
				} else {
					sum += testSite[i] / C + 1;
				}
			}
		}
		System.out.println(sum);
	}
}
