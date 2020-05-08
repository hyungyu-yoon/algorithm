package algorithm.boj.sstest;

import java.io.*;
import java.util.*;

public class Main_14501_퇴사 {
	static int N;
	static int[] T;
	static int[] P;
	static int[] day;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		T = new int[N+1];
		P = new int[N+1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		day = new int[N+7];
		for (int i = 1; i <= N; i++) {
			day[i+1] = Math.max(day[i], day[i+1]);
			day[i + T[i]] = Math.max(day[T[i]+i], P[i]+day[i]);
		}
		System.out.println(day[N+1]);
		
	}
}
