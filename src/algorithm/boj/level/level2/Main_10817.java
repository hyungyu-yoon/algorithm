package algorithm.boj.level.level2;

import java.util.Scanner;

public class Main_10817 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		if (A > B) {
			if (C > B) {
				if (A > C) {
					System.out.println(C);
				} else {
					System.out.println(A);
				}
			} else {
				System.out.println(B);
			}
		} else {
			if (C > A) {
				if(B > C) {
					System.out.println(C);
				}else {
					System.out.println(B);
				}
			} else {
				System.out.println(A);
			}
		}

	}
}
