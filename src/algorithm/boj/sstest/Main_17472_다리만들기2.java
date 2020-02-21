package algorithm.boj.sstest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17472_다리만들기2 {
	static int N;
	static int M;
	static int[][] island;
	static boolean[][] visited;
	static int[][] graph;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int cost = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		island = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				island[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int count = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (island[i][j] == 1 && !visited[i][j]) {
					Queue<Point> q = new LinkedList<>();
					q.add(new Point(i, j));

					while (!q.isEmpty()) {
						Point p = q.poll();
						if (visited[p.x][p.y]) {
							continue;
						}
						island[p.x][p.y] = count;
						visited[p.x][p.y] = true;

						for (int k = 0; k < 4; k++) {
							int newX = p.x + dx[k];
							int newY = p.y + dy[k];

							if (newX < 0 || newY < 0 || newX >= N || newY >= M || island[newX][newY] == 0
									|| visited[newX][newY]) {
								continue;
							}

							q.add(new Point(newX, newY));

						}
					}
					count++;
				}
			}
		}

		graph = new int[count][count];
		for (int i = 1; i < count; i++) {
			for (int j = 1; j < count; j++) {
				graph[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (island[i][j] != 0) {
					for (int k = 0; k < 4; k++) {
						count = 0;
						int x = i + dx[k];
						int y = j + dy[k];

						while (x >= 0 && y >= 0 && x < N && y < M && island[x][y] != island[i][j]) {
							if (island[x][y] == 0) {
								count++;
								x += dx[k];
								y += dy[k];
								continue;
							} else {
								if(count < 2) {
									break;
								}
								graph[island[i][j]][island[x][y]] = Math.min(graph[island[i][j]][island[x][y]], count);
								break;
							}
						}
					}
				}
			}
		}
		
		int[] visited = new int[graph.length];
		visited[1] = 1;
		
		prim(graph, visited, 1);
		boolean check = false;
		for (int i = 1; i < visited.length; i++) {
			if(visited[i] == 0) {
				check = true;
				break;
			}
		}
		if(check) {
			System.out.println("-1");
		}else {
			System.out.println(cost);
		}
	}

	public static void prim(int[][] array, int[] visited, int depth) {
		if (depth == visited.length -1) {
			return;
		}

		int min = Integer.MAX_VALUE;
		int indexX = 0;
		int indexY = 0;

		for (int i = 1; i < visited.length; i++) {
			if (visited[i] == 1) {
				for (int j = 1; j < array.length; j++) {

					if (i == j)
						continue;

					if (visited[j] == 1)
						continue;

					if (array[i][j] >= 2 && array[i][j] < min) {
						min = array[i][j];
						indexX = i;
						indexY = j;
					}
				}
			}
		}

		visited[indexX] = 1;
		visited[indexY] = 1;
		cost += min;

		prim(array, visited, depth + 1);
	}

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
