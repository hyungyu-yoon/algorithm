package algorithm.boj.level.level4;

import java.util.Scanner;

public class Main_10952 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		while(A != 0 && B != 0) {
			
			System.out.println(A+B);
			A = sc.nextInt();
			B = sc.nextInt();
		}
	}
}
