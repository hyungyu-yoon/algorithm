package algorithm.swexpertacademy.swtest;

import java.io.*;
import java.util.*;


public class Solution_5646_벽돌깨기{
	static int N;
    static int min;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] block = new ArrayList[W];
 
            min = Integer.MAX_VALUE;
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
 
                for (int j = 0; j < block.length; j++) {
                    if (block[j] == null) {
                        block[j] = new ArrayList<>();
                    }
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 0) {
                        continue;
                    }
 
                    block[j].add(0, num);
                }
            }
            for (int i = 0; i < block.length; i++) {
                solve(block, 0, i);
            }
            System.out.println("#" + tc+" " + min);
        }
    }
 
    static void solve(ArrayList<Integer>[] block, int d, int index) {
        if (d == N) {
            int sum = 0;
            for (int i = 0; i < block.length; i++) {
                sum += block[i].size();
            }
            min = Math.min(sum, min);
            return;
        }
        ArrayList<Integer>[] tmp = new ArrayList[block.length];
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == null) {
                tmp[i] = new ArrayList<>();
            }
            for (int j = 0; j < block[i].size(); j++) {
                tmp[i].add(block[i].get(j));
            }
        }
 
        Queue<Point> q = new LinkedList<>();
        if (tmp[index].size() > 0) {
            q.add(new Point(index, tmp[index].size() - 1));
        }
        while (!q.isEmpty()) {
            Point p = q.poll();
 
            for (int i = 0; i < 4; i++) {
                int tx = p.x;
                int ty = p.y;
                if (i == 0) {
                    for (int j = 0; j < tmp[p.x].get(p.y)-1; j++) {
                        tx++;
                        if (tx < 0 || tx >= tmp.length || ty < 0 || ty >= tmp[tx].size()) {
                            continue;
                        }
 
                        if (tmp[tx].get(ty) == 1) {
                            tmp[tx].set(ty, 0);
                        } else if (tmp[tx].get(ty) > 1) {
                            q.add(new Point(tx, ty));
                        }
                    }
                } else if (i == 1) {
                    for (int j = 0; j < tmp[p.x].get(p.y)-1; j++) {
                        tx--;
                        if (tx < 0 || tx >= tmp.length || ty < 0 || ty >= tmp[tx].size()) {
                            continue;
                        }
 
                        if (tmp[tx].get(ty) == 1) {
                            tmp[tx].set(ty, 0);
                        } else if (tmp[tx].get(ty) > 1) {
                            q.add(new Point(tx, ty));
                        }
                    }
                } else if (i == 2) {
                    for (int j = 0; j < tmp[p.x].get(p.y)-1; j++) {
                        ty++;
                        if (tx < 0 || tx >= tmp.length || ty < 0 || ty >= tmp[tx].size()) {
                            continue;
                        }
 
                        if (tmp[tx].get(ty) == 1) {
                            tmp[tx].set(ty, 0);
                        } else if (tmp[tx].get(ty) > 1) {
                            q.add(new Point(tx, ty));
                        }
                    }
                } else {
                    for (int j = 0; j < tmp[p.x].get(p.y)-1; j++) {
                        ty--;
                        if (tx < 0 || tx >= tmp.length || ty < 0 || ty >= tmp[tx].size()) {
                            continue;
                        }
 
                        if (tmp[tx].get(ty) == 1) {
                            tmp[tx].set(ty, 0);
                        } else if (tmp[tx].get(ty) > 1) {
                            q.add(new Point(tx, ty));
                        }
                    }
                }
            }
            tmp[p.x].set(p.y, 0);
        }
 
        for (int i = 0; i < tmp.length; i++) {
            int size = tmp[i].size();
            int a = 0;
            for (int j = 0; j < size; j++) {
                if (tmp[i].get(a) == 0) {
                    tmp[i].remove(a);
                } else {
                    a++;
                }
            }
        }
 
        for (int i = 0; i < block.length; i++) {
            solve(tmp, d + 1, i);
        }
 
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
