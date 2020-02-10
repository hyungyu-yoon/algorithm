package algorithm.boj.level.level4;

import java.util.Scanner;

public class Main_1110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int newN = N;
		int sum = 0;
		int count = 0;
		while(true) {
			count++;
			sum = newN/10 + newN%10;
			newN = (newN%10)*10 + sum%10;
			if(N == newN) {
				break;
			}
		}
		System.out.println(count);
	}
}
