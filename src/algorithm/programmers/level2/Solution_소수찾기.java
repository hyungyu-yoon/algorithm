package algorithm.programmers.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_소수찾기 {
    private Set<String> set = new HashSet<>();

    public int solution(String numbers) {
        int answer = 0;

        set.clear();
        int[] num = new int[numbers.length()];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(numbers.charAt(i) + "");
        }

        for (int i = 1; i <= num.length; i++) {
            permutation(num, 0, num.length, i);
        }

        return set.size();
    }

    void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < r; i++){
                sb.append(arr[i]);
            }

            if(isPrime(Integer.parseInt(sb.toString()))){
                set.add(sb.toString());
            }

            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            if(arr[0] != 0){
                permutation(arr, depth + 1, n, r);
            }
            swap(arr, depth, i);
        }
    }

    void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    boolean isPrime(int n) {
        if(n < 2){
            return false;
        }
        double sqrt = Math.sqrt(n);
        boolean check = true;
        for (int i = 2; i <= sqrt; i++) {
            if(n%i == 0) {
                check = false;
                break;
            }
        }
        return check;
    }

    public static void main(String[] args) {
        Solution_소수찾기 s = new Solution_소수찾기();
        s.solution("011");
    }
}
