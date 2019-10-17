package algorithm.swexpertacademy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_2477_차량정비소 {
	static int N;
	static int M;
	static int K;
	static int A;
	static int B;
	static int[] ai;
	static int[] bi;
	static int[] tk;
	static Customer[] c;
	static int sum;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			ai = new int[N+1];
			bi = new int[M+1];
			tk = new int[K];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N+1; i++) {
				ai[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < M+1; i++) {
				bi[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) {
				tk[i] = Integer.parseInt(st.nextToken());
			}
			
			sum = 0;
			sol();
			System.out.println("#" + tc+ " " + ((sum == 0) ? "-1" : sum));
		}
	}
	
	
	static public void sol() {
		ArrayList<Customer> stage1 = new ArrayList<>();
		ArrayList<Customer> stage2 = new ArrayList<>();
		ArrayList<Customer> stage3 = new ArrayList<>();
		ArrayList<Customer> stage4 = new ArrayList<>();
		ArrayList<Customer> stage5 = new ArrayList<>();
		
		boolean[] desk = new boolean[N+1];
		boolean[] repair = new boolean[M+1];
		
		for (int i = 0; i < K; i++) {
			stage1.add(new Customer(i+1, 0, 0, tk[i]));
		}
		
		while(stage5.size() != K) {
			for (int i = 0; i < stage1.size(); i++) {
				if(stage1.get(i).time == 0) {
					for (int j = 1; j < ai.length; j++) {
						if(desk[j]) {
							continue;
						}
						stage1.get(i).a = j;
						stage1.get(i).time = ai[j]-1;
						
						stage2.add(stage1.remove(i));
						desk[j] = true;
						i--;
						break;
					}
				}
			}
			
			PriorityQueue<Customer> q = new PriorityQueue<>();
			for (int i = 0; i < stage2.size(); i++) {
				if(stage2.get(i).time == 0) {
					desk[stage2.get(i).a] = false;
					q.offer(stage2.remove(i));
					i--;
				}
			}
			while(!q.isEmpty()) {
				stage3.add(q.poll());
			}
			
			for (int i = 0; i < stage3.size(); i++) {
				for (int j = 1; j < bi.length; j++) {
					if(repair[j]) {
						continue;
					}
					stage3.get(i).b = j;
					stage3.get(i).time = bi[j]-1;
					stage4.add(stage3.remove(i));
					i--;
					repair[j] = true;
					break;
				}
			}
			
			for (int i = 0; i < stage4.size(); i++) {
				if(stage4.get(i).time == 0) {
					repair[stage4.get(i).b] = false;
					stage5.add(stage4.remove(i));
					i--;
				}
			}
			
			for (int i = 0; i < stage1.size();i++) {
				if(stage1.get(i).time > 0) {
					stage1.get(i).time--;
				}
			}
			
			for (int i = 0; i < stage2.size();i++) {
				if(stage2.get(i).time > 0) {
					stage2.get(i).time--;
				}
			}
			for (int i = 0; i < stage4.size();i++) {
				if(stage4.get(i).time > 0) {
					stage4.get(i).time--;
				}
			}
			
			
		}
		
		for (int i = 0; i < stage5.size(); i++) {
			if(stage5.get(i).a == A && stage5.get(i).b == B) {
				sum += stage5.get(i).num;
			}
		}
		
		
	}
	
	static class Customer implements Comparable<Customer>{
		int num;
		int a;
		int b;
		int time;

		@Override
		public String toString() {
			return "Customer [num=" + num + ", a=" + a + ", b=" + b + ", time=" + time + "]";
		}

		public Customer(int num,int a, int b, int time) {
			this.num = num;
			this.a = a;
			this.b = b;
			this.time = time;
		}

		@Override
		public int compareTo(Customer o) {
			if(this.a > o.a) {
				return 1;
			}else {
				return -1;
			}
		}
	}
}
