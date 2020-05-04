package algorithm.boj.dfs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9466_텀프로젝트 {

	static int T,N;
	static int[] student;
	static boolean[] used;
	static boolean[] team;
	static int count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		 T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			student = new int[N];
			for (int i = 0; i < N; i++) {
				student[i] = Integer.parseInt(st.nextToken()) - 1 ;
			}
			
			used = new boolean[N];
			team = new boolean[N];
			count = 0;
			for (int i = 0; i < N; i++) {
				if(team[i]) {
					continue;
				}
				dfs(i);
			}
			System.out.println(N-count);
		}
		
	}
	
	static void dfs(int i) {
		if (used[i]) {
            team[i] = true;
            count++;
        } else {
            used[i] = true;
        }

        int next = student[i];

        if (!team[next]) {
            dfs(next);
        }

        used[i] = false;
        team[i] = true;
	}

}
