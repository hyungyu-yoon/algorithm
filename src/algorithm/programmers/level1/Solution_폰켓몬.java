package algorithm.programmers.level1;

import java.util.Arrays;


public class Solution_폰켓몬 {
    public int solution(int[] nums) {
        int N = nums.length/2;
        int count = (int) Arrays.stream(nums).distinct().count();
        return N > count ? N : count;
    }
}
