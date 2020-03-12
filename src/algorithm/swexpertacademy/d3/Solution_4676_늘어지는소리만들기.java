package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4676_늘어지는소리만들기 {
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			
			int H = Integer.parseInt(br.readLine());
			
			int[] count = new int[str.length()+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < H; i++) {
				count[Integer.parseInt(st.nextToken())]++;
			}
			
			System.out.print("#" +tc + " ");

			int index = 0;
			for (int i = 0; i < count.length; i++) {
				for (int j = 0; j < count[i]; j++) {
					System.out.print("-");
				}
				if(index < str.length()) {
					System.out.print(str.charAt(index++));
				}
			}
			System.out.println();
		}
	}
	
}
