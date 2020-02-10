package algorithm.boj.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6603_로또 {

	static int[] number;
	static boolean[] used;
	static int k;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			
			if(k == 0) {
				break;
			}
			
			number = new int[k];
			used = new boolean[k];
			for (int i = 0; i < k; i++) {
				number[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0,0);
			System.out.println();
		}
		
	}
	
	static void combination(int start, int r) {
	    if(r == 6) {
	    	for (int i = 0; i < number.length; i++) {
				if(used[i]) {
					System.out.print(number[i] + " ");
				}
			}
	    	System.out.println();
	        return;
	    } else {
	        for(int i=start; i<k; i++) {
	        	used[i] = true;
	            combination(i + 1, r + 1);
	            used[i] = false;
	        }
	    }
	}

	
}
