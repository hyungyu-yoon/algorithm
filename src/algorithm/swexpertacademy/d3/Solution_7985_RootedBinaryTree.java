package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_7985_RootedBinaryTree {
	
	static ArrayList<Integer>[] ans;
	static int[] tree;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int size = (int) Math.pow(2, N) - 1;
			tree = new int[size];
			
			for (int i = 0; i < size; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				ans[i] = new ArrayList<Integer>();
			}
			solve(0, size-1, 0);
			System.out.print("#" +tc + " " );
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < ans[i].size(); j++) {
					System.out.print(ans[i].get(j) + " ");
				}
				System.out.println();
			}
		}
	}
	
	static void solve(int l, int r,int d) {
		if(l > r) {
			return;
		}
		
		int mid = (l + r)/2;
		ans[d].add(tree[mid]);
		solve(l, mid-1, d+1);
		solve(mid+1, r, d+1);
	}
}
