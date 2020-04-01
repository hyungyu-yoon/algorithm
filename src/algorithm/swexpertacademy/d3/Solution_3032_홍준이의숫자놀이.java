package algorithm.swexpertacademy.d3;

import java.io.*;
import java.util.*;

public class Solution_3032_홍준이의숫자놀이 {
	static int x1, y1, x2, y2;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			int result = solve(A, B);
			if (result == 1)
				System.out.println("#" +tc + " " + x1 + " " + y1);
			else if (result == 2)
				System.out.println("#" +tc + " " + x2 + " " + y2);
			else
				System.out.println("#" +tc + " -1");
		}
	}

	static int solve(int a, int b) {
		x1 = 1;
		y1 = 0;
		x2 = 0;
		y2 = 1;
		while (true) {
			if (a == 1)
				return 1;
			if (b == 1)
				return 2;
			if (a == 0 || b == 0)
				return 0;
			x1 -= a / b * x2;
			y1 -= a / b * y2;
			a %= b;
			x2 -= b / a * x1;
			y2 -= b / a * y1;
			b %= a;
		}
	}

}
