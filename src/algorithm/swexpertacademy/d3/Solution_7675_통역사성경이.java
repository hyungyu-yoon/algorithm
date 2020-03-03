package algorithm.swexpertacademy.d3;

import java.util.Scanner;

public class Solution_7675_통역사성경이 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			
			int count = 0;
			int nameCount = 0;
			System.out.print("#" + tc + " ");
			while (count < N) {
				String str = sc.next();
				if (str.charAt(str.length() - 1) == '.' || str.charAt(str.length() - 1) == '!'
						|| str.charAt(str.length() - 1) == '?') {
					count++;
					if(check(str.substring(0,str.length()-1))) {
						nameCount++;
					}
					System.out.print(nameCount + " ");
					nameCount = 0;
					continue;
				}
				
				if(check(str)) {
					nameCount++;
				}
				
			}
			System.out.println();
			
		}
	}
	
	static boolean check(String str) {
		
		int a = 0;
		int b = 0;
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(c >= 'A' && c <= 'Z') {
				a++;
			}
			
			if(c >= 'a' && c <= 'z') {
				b++;
			}
		}
		
		if(a == 1 && a+b == str.length()) {
			return true;
		}else {
			return false;
		}
	}
	

}
