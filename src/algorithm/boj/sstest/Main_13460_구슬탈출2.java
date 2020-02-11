package algorithm.boj.sstest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_13460_구슬탈출2 {
	static int N;
	static int M;
	static char[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Point red = null;
		Point blue = null;
		Point hole = null;

		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			board[i] = str.toCharArray();
			if (str.contains("R")) {
				red = new Point(i, str.indexOf('R'), 0);
				board[i][red.y] = '.';
			}
			if (str.contains("B")) {
				blue = new Point(i, str.indexOf('B'), 0);
				board[i][blue.y] = '.';
			}
			if (str.contains("O")) {
				hole = new Point(i, str.indexOf('O'), 0);
			}
		}

		Queue<Point> q = new LinkedList<>();
		q.add(red);
		q.add(blue);
		int count = -1;
		while (!q.isEmpty()) {
			red = q.poll();
			blue = q.poll();
			
			if(red.c == 10) {
				continue;
			}

			Point newR = null;
			Point newB = null;
			// up
			if (red.x < blue.x) {
				newR = up(red,blue);
				newB = up(blue,newR);
			} else {
				newB = up(blue,red);
				newR = up(red,newB);
			}
			
			if(newB.x == hole.x && newB.y == hole.y) {
				count = -1;
			}else if(newR.x == hole.x && newR.y == hole.y) {
				count = newR.c;
				break;
			}else {
				if(!(newR.x == red.x && newR.y == red.y && newB.x == blue.x && newB.y == blue.y)) {
					q.add(newR);
					q.add(newB);
				}
			}
			
			// down
			if (red.x > blue.x) {
				newR = down(red,blue);
				newB = down(blue,newR);
			} else {
				newB = down(blue,red);
				newR = down(red,newB);
			}
			
			if(newB.x == hole.x && newB.y == hole.y) {
				count = -1;
			}else if(newR.x == hole.x && newR.y == hole.y) {
				count = newR.c;
				break;
			}else {
				if(!(newR.x == red.x && newR.y == red.y && newB.x == blue.x && newB.y == blue.y)) {
					q.add(newR);
					q.add(newB);
				}
			}
			// left
			if (red.y < blue.y) {
				newR = left(red,blue);
				newB = left(blue,newR);
			} else {
				newB = left(blue,red);
				newR = left(red,newB);
			}
			
			if(newB.x == hole.x && newB.y == hole.y) {
				count = -1;
			}else if(newR.x == hole.x && newR.y == hole.y) {
				count = newR.c;
				break;
			}else {
				if(!(newR.x == red.x && newR.y == red.y && newB.x == blue.x && newB.y == blue.y)) {
					q.add(newR);
					q.add(newB);
				}
			}
			// right
			if (red.y > blue.y) {
				newR = right(red,blue);
				newB = right(blue,newR);
			} else {
				newB = right(blue,red);
				newR = right(red,newB);
			}
			
			if(newB.x == hole.x && newB.y == hole.y) {
				count = -1;
			}else if(newR.x == hole.x && newR.y == hole.y) {
				count = newR.c;
				break;
			}else {
				if(!(newR.x == red.x && newR.y == red.y && newB.x == blue.x && newB.y == blue.y)) {
					q.add(newR);
					q.add(newB);
				}
			}
		}
		System.out.println(count);
	}

	private static Point right(Point p1, Point p2) {
		int y = p1.y;
		for (int i = p1.y + 1 ; i < M; i++) {
			
			if(board[p1.x][i] == 'O') {
				y = i;
				break;
			}
			
			if(board[p1.x][i] == '#' || (p1.x == p2.x && i == p2.y)) {
				break;
			}
			if(board[p1.x][i] == '.') {
				y = i;
				continue;
			}
		}
		
		return new Point(p1.x, y, p1.c+1);
	}

	private static Point left(Point p1, Point p2) {
		int y = p1.y;
		for (int i = p1.y - 1 ; i > 0; i--) {
			if(board[p1.x][i] == 'O') {
				y = i;
				break;
			}
			if(board[p1.x][i] == '#' || (p1.x == p2.x && i == p2.y)) {
				break;
			}
			
			
			if(board[p1.x][i] == '.') {
				y = i;
				continue;
			}
		}
		
		return new Point(p1.x, y, p1.c+1);
	}

	private static Point down(Point p1, Point p2) {
		int x = p1.x;
		for (int i = p1.x + 1 ; i < N; i++) {
			if(board[i][p1.y] == 'O') {
				x = i;
				break;
			}
			if(board[i][p1.y] == '#' || (p1.y == p2.y && i == p2.x)) {
				break;
			}
			
			
			if(board[i][p1.y] == '.') {
				x = i;
				continue;
			}
			
		}
		
		return new Point(x, p1.y, p1.c+1);
	}

	static Point up(Point p1, Point p2) {
		int x = p1.x;
		for (int i = p1.x - 1; i > 0; i--) {
			if(board[i][p1.y] == 'O') {
				x = i;
				break;
			}
			if(board[i][p1.y] == '#' || (p1.y == p2.y && i == p2.x)) {
				break;
			}
			
			
			if(board[i][p1.y] == '.') {
				x = i;
				continue;
			}
		}
		
		return new Point(x, p1.y, p1.c+1);
	}

	static class Point {
		int x, y, c;

		Point(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}
	}
}
