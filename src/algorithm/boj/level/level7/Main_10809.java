package algorithm.boj.level.level7;

import java.util.Arrays;
import java.util.Scanner;

public class Main_10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		int[] first = new int[26];
		Arrays.fill(first, -1);
		for (int i = 0; i < S.length(); i++) {
			if(first[S.charAt(i) - 'a'] == -1) {
				first[S.charAt(i) - 'a'] = i;
			}
		}
		
		for (int i = 0; i < first.length; i++) {
			System.out.print(first[i] + " ");
		}
	}
}
