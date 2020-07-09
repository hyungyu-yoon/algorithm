package algorithm.swexpertacademy.d3;

import java.io.*;
import java.util.*;

public class Solution_6019_기차사이의파리 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double D = Double.parseDouble(st.nextToken());
			double A = Double.parseDouble(st.nextToken());
			double B = Double.parseDouble(st.nextToken());
			double F = Double.parseDouble(st.nextToken());
			System.out.printf("#" + tc +" " + "%.6f", D/(A+B)*F);
		}
	}
}
