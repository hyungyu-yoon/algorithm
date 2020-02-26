package algorithm.boj.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1389_케빈베이컨의6단계법칙 {

	static int N;
	static int M;
	static int[][] user;
	static boolean[] visited;
	static int kevin;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		user = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			user[a][b] = 1;
			user[b][a] = 1;
		}

		int min = Integer.MAX_VALUE;
		int userNumber = Integer.MAX_VALUE;
		for (int i = 1; i <= N; i++) {
			int kevinSum = 0;

			for (int j = 1; j <= N; j++) {
				kevin = Integer.MAX_VALUE;
				visited = new boolean[N + 1];
				if (i == j) {
					continue;
				}

				kevin(j, i, 0);
				kevinSum += kevin;
			}
			if(kevinSum < min) {
				min = kevinSum;
				userNumber = i;
			}
		}

		System.out.println(userNumber);
	}

	static void kevin(int target, int current, int count) {
		if (target == current) {
			kevin = Math.min(kevin, count);
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (current == i) {
				continue;
			}

			if (visited[i]) {
				continue;
			}
			if (user[current][i] == 1) {
				visited[current] = true;
				kevin(target, i, count + 1);
				visited[current] = false;
			}
		}
	}

}
