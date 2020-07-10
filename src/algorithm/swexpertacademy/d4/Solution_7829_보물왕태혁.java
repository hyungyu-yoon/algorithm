package algorithm.swexpertacademy.d4;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
 
public class Solution_7829_보물왕태혁{
 
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
        	int P = Integer.parseInt(br.readLine());
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	
        	int[] array = new int[P];
        	for (int i = 0; i < P; i++) {
				array[i] = Integer.parseInt(st.nextToken());
			}
        	
        	Arrays.sort(array);
        	
        	int answer = 0;
        	if(P == 1) {
        		answer = array[0]*array[0];
        	}else {
        		answer = array[0]*array[P-1];
        	}
        	System.out.println("#" +tc + " " + answer);
        }
    }
}
