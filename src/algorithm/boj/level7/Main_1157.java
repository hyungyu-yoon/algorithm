package algorithm.boj.level7;

import java.util.Scanner;

public class Main_1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		s = s.toUpperCase();
		int[] count = new int[26];
		
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'A']++;
		}
		
		int max = 0;
		int index = 0;
		for (int i = 0; i < count.length; i++) {
			if(max < count[i]) {
				max = count[i];
				index = i;
			}
		}
		
		int res = 0;
		for (int i = 0; i < count.length; i++) {
			if(count[i] == max) {
				res++;
			}
		}
		
		if(res == 1) {
			System.out.println((char)(index + 'A'));
		}else {
			System.out.println("?");
		}
	}
}
