package algorithm.boj.level.level7;

import java.util.Scanner;

public class Main_2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int R = 0;
		for (int i = 0; i < T; i++) {
			R = sc.nextInt();
			String s = sc.next();
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < s.length(); j++) {
				for (int k = 0; k < R; k++) {
					sb.append(s.charAt(j));
				}
			}
			System.out.println(sb);
		}
	}
}
