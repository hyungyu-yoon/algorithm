package algorithm.swexpertacademy.d3;

public class Solution_3131_100만이하의모든소수 {
	
	
	public static void main(String[] args) throws Exception{
		for (int i = 2; i < 10000; i++) {
			double sqrt = Math.sqrt(i);
			boolean check = true;
			for (int j = 2; j <= sqrt; j++) {
				if(i%j == 0) {
					check = false;
					break;
				}
			}
			if(check) {
				System.out.print(i + " ");
			}
		}
	}
	
}
