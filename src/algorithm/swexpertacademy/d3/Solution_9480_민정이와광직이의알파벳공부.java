package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_9480_민정이와광직이의알파벳공부 {
	
	static String[] words;
	static boolean[] used;
	static int N;
	static int count;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			words = new String[N];
			used = new boolean[N];
			for (int i = 0; i < N; i++) {
				words[i] = br.readLine();
			}
			count = 0;
			subSet(0);
			
			
			
			System.out.println("#" + tc + " " + count);
		}
	}
	
	static void subSet(int d) {
		if(d == N) {
			boolean[] alpa = new boolean[26];
			for (int i = 0; i < used.length; i++) {
				if(used[i]) {
					for (int j = 0; j < words[i].length(); j++) {
						alpa[words[i].charAt(j) - 'a'] = true;
					}
				}
			}
			
			boolean check = true;
			for (int i = 0; i < alpa.length; i++) {
				if(!alpa[i]) {
					check = false;
					break;
				}
			}
			
			if(check) {
				count++;
			}
			return;
		}
		
		used[d] = true;
		subSet(d+1);
		
		used[d] = false;
		subSet(d+1);
	}
	
}
