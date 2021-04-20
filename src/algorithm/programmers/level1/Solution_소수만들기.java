package algorithm.programmers.level1;

public class Solution_소수만들기 {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(isPrime(sum)) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    public boolean isPrime(int sum) {
        boolean check = true;
        double sqrt = Math.sqrt(sum);
        for (int i = 2; i <= sqrt; i++) {
            if(sum%i == 0) {
                check = false;
                break;
            }
        }

        return check;
    }
}
