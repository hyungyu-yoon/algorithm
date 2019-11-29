package algorithm.boj.level7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1316 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int count = 0;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			boolean[] check = new boolean[26];
			boolean isGroup = true;
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if(check[c - 'a']) {
					isGroup = false;
					break;
				}
				check[c - 'a'] = true;
				int index = j+1;
				while(index < s.length() && c == s.charAt(index)) {
					index++;
					j++;
				}
			}
			
			if(isGroup) {
				count++;
			}
		}
		System.out.println(count);
	}
}
