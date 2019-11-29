package algorithm.boj.level7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2908 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = new StringBuilder(st.nextToken()).reverse().toString();
		String B = new StringBuilder(st.nextToken()).reverse().toString();
		System.out.println(Math.max(Integer.parseInt(A), Integer.parseInt(B)));
	}
}
