package algorithm.boj.level.level6;

import java.util.Scanner;

public class Main_1065 {

	public static void main(String[] args) {
		boolean[] han = new boolean[1001];
		for (int i = 1; i < han.length; i++) {
			han[i] = han(i);
		}
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count = 0;
		for (int i = 1; i <= num; i++) {
			if(han[i]) {
				count++;
			}
		}
		System.out.println(count);
		
	}
	
	static boolean han(int n) {
		if(n < 100) {
			return true;
		}else {
			int left = n/100;
			int mid = (n/10)%10;
			int right = n%10;
			
			if(left - mid == mid - right) {
				return true;
			}else {
				return false;
			}
		}
	}

}
