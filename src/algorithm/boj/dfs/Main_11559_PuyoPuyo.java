package algorithm.boj.dfs;

import java.io.*;
import java.util.*;

public class Main_11559_PuyoPuyo {

	static ArrayList<ArrayList<Character>> puyo;
	static ArrayList<Point> memory = new ArrayList();
	static boolean[][] visited;
	static int sum;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		puyo = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			puyo.add(new ArrayList<>());
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 12; i++) {
			sb.append(br.readLine());
			for (int j = 0; j < 6; j++) {
				if (sb.charAt(j) == '.') {
					continue;
				}
				puyo.get(j).add(0, sb.charAt(j));
			}
			sb.setLength(0);
		}
		
		boolean check;
		int count = 0;
		while (true) {
			check = false;
			visited = new boolean[6][12];
			for (int i = 0; i < 6; i++) {
				memory.clear();
				for (int j = 0; j < puyo.get(i).size(); j++) {
					if (visited[i][j]) {
						continue;
					}
					memory.clear();
					sum = 1;
					visited[i][j] = true;
					memory.add(new Point(i, j));
					dfs(i, j, puyo.get(i).get(j));

					if (sum >= 4) {
						check = true;
						for (int k = 0; k < memory.size(); k++) {
							Point p = memory.get(k);
							puyo.get(p.x).set(p.y, 'X');
						}
					}
				}
			}
			
			for (int i = 0; i < 6; i++) {
				int size = puyo.get(i).size() - 1;
				for (int j = size; j >= 0 ; j--) {
					if(puyo.get(i).get(j) == 'X') {
						puyo.get(i).remove(j);
					}
				}
			}
			
			
			if(!check) {
				break;
			}
			count++;
		}
		System.out.println(count);
	}

	static void dfs(int r, int c, char color) {
		for (int i = 0; i < 4; i++) {
			int x = r + dx[i];
			int y = c + dy[i];

			if (x < 0 || y < 0 || x >= 6 || y >= puyo.get(x).size() || visited[x][y]) {
				continue;
			}
			if (color == puyo.get(x).get(y)) {
				visited[x][y] = true;
				sum++;
				memory.add(new Point(x, y));
				dfs(x, y, color);
			}
		}

	}

	static class Point {
		int x, y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}

	}
}
