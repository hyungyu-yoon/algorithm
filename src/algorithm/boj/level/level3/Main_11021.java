package algorithm.boj.level.level3;

import java.util.Scanner;

public class Main_11021 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int A = 0;
		int B = 0;
		for (int i = 1; i <= T; i++) {
			A = sc.nextInt();
			B = sc.nextInt();
			System.out.println("Case #" + i +": " + (A+B));
		}
	
	}
}
