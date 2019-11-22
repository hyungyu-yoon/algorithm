package algorithm.boj.level1;

import java.util.Scanner;

public class Main_2588 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int mul = A*B;
		while(B/10 != 0 || B%10 != 0) {
			int d = B%10;
			System.out.println(A*d);
			B/=10;
		}
		System.out.println(mul);
	}
}
