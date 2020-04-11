package algorithm.boj.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2309_일곱난쟁이 {

	static int[] dwarf;
	static int[] result;
	static boolean check;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dwarf = new int[9];
		result = new int[7];
		for (int i = 0; i < 9; i++) {
			dwarf[i] = Integer.parseInt(br.readLine());
		}
		
		combination(0, 0);
		

	}
	
	static void combination(int target, int cnt) {
		if(check) {
			return;
		}
		
		if (cnt == result.length) {
			int sum = 0;
			for (int i = 0; i < result.length; i++) {
				sum += result[i];
			}
			
			if(sum == 100) {
				Arrays.sort(result);
				for (int i = 0; i < result.length; i++) {
					System.out.println(result[i]);
				}
				check = true;
			}
			
			return;
		} else if (target == dwarf.length) {
			return;
		} else { 
			result[cnt] = dwarf[target]; 
			combination(target + 1, cnt + 1);
			combination(target + 1, cnt); 
		}
	}

}
