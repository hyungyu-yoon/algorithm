package algorithm.programmers.level1;

import java.util.Arrays;

public class Solution_체육복 {
	static int max;
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		
		int[] students = new int[n];
		
		Arrays.fill(students, 1);
		for (int i = 0; i < lost.length; i++) {
			students[lost[i]-1] = 0;
		}
		
		for (int i = 0; i < reserve.length; i++) {
			students[reserve[i] - 1]++; 
		}
		
		max = 0;
		solve(students,0,0);
		answer = max;
		return answer;
	}
	
	public void solve(int[] students, int n, int sum) {
		if(n == students.length) {
			max = Math.max(max, sum);
			return;
		}
		
		if(students[n] == 2) {
			if(n-1 >= 0 && students[n-1] == 0) {
				students[n-1]++;
				students[n]--;
				solve(students,n+1,sum+2);
				students[n-1]--;
				students[n]++;
			}
			
			if(n+1 < students.length && students[n+1] == 0) {
				students[n+1]++;
				students[n]--;
				solve(students,n+2,sum+2);
				students[n+1]--;
				students[n]++;

			}
			
			solve(students,n+1,sum+1);
		}else if(students[n] == 1) {
			solve(students,n+1,sum+1);
		}else {
			solve(students,n+1,sum);
		}
	}
}
