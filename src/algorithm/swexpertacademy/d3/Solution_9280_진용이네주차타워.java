package algorithm.swexpertacademy.d3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_9280_진용이네주차타워 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			int[] Ri = new int[n+1];
			for (int i = 1; i <= n; i++) {
				Ri[i] = Integer.parseInt(br.readLine());
			}
			
			int[] Wi = new int[m+1];
			for (int i = 1; i <= m; i++) {
				Wi[i] = Integer.parseInt(br.readLine());
			}
			
			boolean[] used = new boolean[n+1];
			int[] usedNum = new int[m+1];
			int price = 0;
			
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < 2*m; i++) {
				int num = Integer.parseInt(br.readLine());
				if(num > 0) {
					boolean isFull = true;
					for (int j = 1; j <= n; j++) {
						if(!used[j]) {
							used[j] = true;
							usedNum[num] = j;
							price += Ri[j]*Wi[num];
							isFull = false;
							break;
						}
					}
					if(isFull) {
						q.add(num);
					}
				}else {
					used[usedNum[num*-1]] = false;
					while(!q.isEmpty()) {
						int temp = q.poll();
						used[usedNum[num*-1]] = true;
						usedNum[temp] = usedNum[num*-1];
						price += Ri[usedNum[num*-1]]*Wi[temp];
						usedNum[num*-1] = 0;
						
						break;
					}
				}
			}
			System.out.println("#" + tc+ " " + price);
		}
	}

}
