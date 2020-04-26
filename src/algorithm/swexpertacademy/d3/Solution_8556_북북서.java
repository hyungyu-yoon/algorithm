package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_8556_북북서 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			
			str = str.replaceAll("west", "0").replaceAll("north", "1");
			
			
			int m = str.charAt(str.length() - 1) == '0' ? 90 : 0; 
			int d = 1;
			int count = 1;
			for (int i = str.length() - 2; i >= 0 ; i--) {
				if(str.charAt(i) == '0') {
					m = m*2 + 90;
				}else {
					m = m*2 - 90;
				}
				count++;
			}
			d = (int) Math.pow(2, count - 1);
			while(m % 2 == 0 && d != 1) {
				m /= 2;
				d /= 2;
			}
			
			if (d == 1)
                System.out.println("#" + tc + " " + m);
            else
                System.out.println("#" + tc + " " + m + "/" + d);
			
		}
	}
}
