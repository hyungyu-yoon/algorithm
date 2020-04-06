package common;

public class Permutation {
	static int cnt=0;
	static int[] array = {1,2,3,4,5,6};
	static boolean[] used = new boolean[array.length];
	static int[] result = new int[array.length];
	
	public static void main(String[] args) {
		System.out.println("===== swap =====");
		perm(0,1);
		System.out.println("cnt="+cnt);
		System.out.println();
		cnt = 0;
		
		System.out.println("===== boolean =====");
		perm2(0,1);
		System.out.println("cnt="+cnt);
	}
	
	// swap 활용
	static void perm(int d,int r) {
		if(d == r) {
			cnt++;
			print(array,r);
			return;
		}
		
		for(int i=d; i<array.length; i++) {
			swap(i, d);
			perm(d+1,r);
			swap(i, d);
		}
	}
	
	static void swap(int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
	
	// used boolean 배열 사용 
	static void perm2(int cnt, int r) {
		if(cnt == r) { 
			Permutation.cnt++;
			print(result,r);
			return;
		}
		
		for(int i=0; i<array.length; i++) {
			if(!used[i]) { 
				used[i] = true;
				result[cnt] = array[i];
				perm2(cnt+1, r); 
				result[cnt] = 0;
				used[i] = false;
			}
		}
	}
	
	static void print(int[] arr, int r) {
		for (int i = 0; i < r; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
