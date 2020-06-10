package algorithm.programmers.level1;

public class Solution_시저암호 {
	public String solution(String s, int n) {
		StringBuilder sb = new StringBuilder();

		char ch = ' ';
		for (int i = 0; i < s.length(); i++) {
			ch = s.charAt(i);

			if (ch >= 'a' && ch <= 'z') {
				ch = (char) ((ch - 'a' + n) % 26 + 'a');
			} else if (ch >= 'A' && ch <= 'Z') {
				ch = (char) ((ch - 'A' + n) % 26 + 'A');
			} 
            sb.append(ch);
		}

		return sb.toString();
	}
}
