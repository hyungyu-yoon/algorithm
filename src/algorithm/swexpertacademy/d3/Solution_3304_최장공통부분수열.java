package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3304_최장공통부분수열 {
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] X = st.nextToken().toCharArray();
			char[] Y = st.nextToken().toCharArray();
			int m = X.length;
			int n = Y.length;
			int a[][] = new int[m+1][n+1];
			for(int i=0; i<=m; i++) {
				for(int j=0; j<=n; j++) {
					if( i==0 || j==0 ) {
						a[i][j] = 0;
						continue;
					}
					if( X[i-1] == Y[j-1] ) {
						a[i][j] = a[i-1][j-1]+1;
						continue;
					}
					a[i][j] = Math.max(a[i-1][j],a[i][j-1]);
				}
			}
			System.out.println("#" + tc + " " + a[m][n]);
		}
	}
	
}
