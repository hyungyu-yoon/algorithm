package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_6853_직사각형과점 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int X1 = Integer.parseInt(st.nextToken());
			int Y1 = Integer.parseInt(st.nextToken());
			int X2 = Integer.parseInt(st.nextToken());
			int Y2 = Integer.parseInt(st.nextToken());
			
			int N = Integer.parseInt(br.readLine());
			
			int inner = 0;
			int outer = 0;
			int collinear = 0;
			
			
			int x = 0, y = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				
				if(x > X1 && x < X2 && y > Y1 && y < Y2) {
					inner++;
				}else if(x < X1 || x > X2 || y < Y1 || y > Y2 ) {
					outer++;
				}else {
					collinear++;
				}
			}
			System.out.println("#" + tc + " " + inner + " " + collinear + " " + outer);
		}
	}
	
}
