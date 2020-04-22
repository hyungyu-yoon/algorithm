package common;
import java.util.Arrays;

public class Combination {
	static int[] arr = { 10, 20, 30, 40,50 };
	static int[] result = new int[2];
	
	static int n = arr.length;
	static int r = 2;

	public static void main(String[] args) {
		combination(0, 0); 
	}

	static void combination(int target, int cnt) {
		if (cnt == r) { 
			System.out.println(Arrays.toString(result));
			return;
		} else if (target == arr.length) { 
			return;
		} else { 
			result[cnt] = arr[target];
			combination(target + 1, cnt + 1); 
			combination(target + 1, cnt); 
		}
	}

}
