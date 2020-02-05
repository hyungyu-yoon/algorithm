package algorithm.swexpertacademy.swtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_2383_점심식사시간 {
	static int N;
	static int[][] map;
	static ArrayList<Point> p;
	static ArrayList<Point> s;
	static boolean[] visited;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			p = new ArrayList<>();
			s = new ArrayList<>();
			StringTokenizer st = null;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1) {
						p.add(new Point(i, j));
					} else if (map[i][j] > 1) {
						s.add(new Point(i, j));
					}
				}
			}
			visited = new boolean[p.size()];

			min = Integer.MAX_VALUE;
			perm(0);
			System.out.println("#" + tc + " " + min);
		}
	}

	static public void sol() {
		ArrayList<Integer> p1 = new ArrayList<>();
		ArrayList<Integer> p2 = new ArrayList<>();

		for (int i = 0; i < visited.length; i++) {
			if (visited[i]) {
				p1.add(Math.abs(p.get(i).x - s.get(0).x) + Math.abs(p.get(i).y - s.get(0).y)+1);
			} else {
				p2.add(Math.abs(p.get(i).x - s.get(1).x) + Math.abs(p.get(i).y - s.get(1).y)+1);
			}
		}

		ArrayList<Integer> s1 = new ArrayList<>();
		ArrayList<Integer> s2 = new ArrayList<>();

		int count = 0;
		while (!p1.isEmpty() || !p2.isEmpty() || !s1.isEmpty() || !s2.isEmpty()) {
			count++;
			for (int i = 0; i < p1.size(); i++) {
				if(p1.get(i) > -1) {
					p1.set(i, p1.get(i)-1);
				}
				if(p1.get(i) == -1 && s1.size() < 3) {
					s1.add(map[s.get(0).x][s.get(0).y]);
					p1.remove(i);
					i--;
				}
			}

			for (int i = 0; i < p2.size(); i++) {
				if(p2.get(i) > -1) {
					p2.set(i, p2.get(i)-1);
				}
				if(p2.get(i) == -1 && s2.size() < 3) {
					s2.add(map[s.get(1).x][s.get(1).y]);
					p2.remove(i);
					i--;
				}
			}
			
			for (int i = 0; i < s1.size(); i++) {
				s1.set(i, s1.get(i)-1);
				if(s1.get(i) == 0) {
					s1.remove(i);
					i--;
				}
			}
			
			for (int i = 0; i < s2.size(); i++) {
				s2.set(i, s2.get(i)-1);
				if(s2.get(i) == 0) {
					s2.remove(i);
					i--;
				}
			}
		}
		if(min > count) {
			min = count;
		}

	}

	static public void perm(int n) {
		if (n == p.size()) {
			sol();
			return;
		}

		visited[n] = true;
		perm(n + 1);
		visited[n] = false;
		perm(n + 1);

	}

	static class Point {
		int x;
		int y;
		int len;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
