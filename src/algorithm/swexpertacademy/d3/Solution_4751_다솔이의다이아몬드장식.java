package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4751_다솔이의다이아몬드장식 {
	
	static int[] dx = {-2,-1,-1,0,0,1,1,2};
	static int[] dy = {0,-1,1,-2,2,-1,1,0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			String str = br.readLine();
			
			char[][] deco = new char[5][5+ (str.length()-1)*4];
			
			for (int i = 0; i < deco.length; i++) {
				for (int j = 0; j < deco[i].length; j++) {
					deco[i][j] = '.';
				}
			}
			
			int index = 0;
			for (int i = 2; i < deco[2].length; i+=4) {
				deco[2][i] = str.charAt(index++);
				
				for (int j = 0; j < 8; j++) {
					int tx = 2 + dx[j];
					int ty = i + dy[j];
					deco[tx][ty] = '#';
				}
			}
			
			for (int i = 0; i < deco.length; i++) {
				for (int j = 0; j < deco[i].length; j++) {
					System.out.print(deco[i][j]);
				}
				System.out.println();
			}
		}
	}
	
}
