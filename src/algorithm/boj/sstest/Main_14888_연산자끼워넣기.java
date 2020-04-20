package algorithm.boj.sstest;

import java.io.*;
import java.util.*;

public class Main_14888_연산자끼워넣기 {
	static int N;
	static int[] A;
	static char[] op;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = new int[N];
		
		for (int i = 0; i < A.length; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		op = new char[N-1];
		int index = 0;
		st = new StringTokenizer(br.readLine());
		char c = ' ';
		for (int i = 0; i < 4; i++) {
			if(i == 0) {
				c = '+';
			}else if(i == 1) {
				c = '-';
			}else if(i == 2) {
				c = '*';
			}else {
				c = '/';
			}
			int size = Integer.parseInt(st.nextToken());
			for (int j = 0; j < size; j++) {
				op[index++] = c;
			}
		}

		
		perm(0,N-1);
		System.out.println(max +"\n" + min);
	}
	
	static void perm(int d,int r) {
		if(d == r) {
			int index = 0;
			int res = A[index++];
			for (int i = 0; i < N-1; i++) {
				char c = op[i];
				int num = A[index++];
				switch (c) {
				case '+':
					res += num;
					break;
				case '-':
					res -= num;
					break;
				case '*':
					res *= num;
					break;
				case '/':
					if(res < 0) {
						res *= -1;
						res /= num;
						res *= -1;
					}else {
						res /= num;
					}
					break;
				}
			}
			
			max = Math.max(max, res);
			min = Math.min(min, res); 
			return;
		}
		
		for(int i=d; i<op.length; i++) {
			swap(i, d);
			perm(d+1,r);
			swap(i, d);
		}
	}
	
	static void swap(int i, int j) {
		char tmp = op[i];
		op[i] = op[j];
		op[j] = tmp;
	}
}
