package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4047_영준이의카드카운팅 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			
			boolean[][] card = new boolean[4][14];
			boolean check = true;
			
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				int num = (str.charAt(i+1) - '0')*10+str.charAt(i+2) - '0';
				i+=2;
				if(ch == 'S') {
					if(card[0][num]) {
						check = false;
						break;
					}
					card[0][num] = true;
				}else if(ch == 'D') {
					if(card[1][num]) {
						check = false;
						break;
					}
					card[1][num] = true;
				}else if(ch == 'H') {
					if(card[2][num]) {
						check = false;
						break;
					}
					card[2][num] = true;
				}else {
					if(card[3][num]) {
						check = false;
						break;
					}
					card[3][num] = true;
				}
			}
			
			if(check) {
				System.out.print("#" + tc + " ");
				for (int i = 0; i < card.length; i++) {
					int count = 0;
					for (int j = 1; j < card[i].length; j++) {
						if(!card[i][j]) {
							count++;
						}
					}
					System.out.print(count + " ");
				}
				System.out.println();
			}else {
				System.out.println("#" + tc + " ERROR" );
			}
			
		}
	}
	
}
