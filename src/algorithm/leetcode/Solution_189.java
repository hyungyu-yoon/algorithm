package algorithm.leetcode;


import algorithm.toss.Solution_1;

import java.util.Arrays;

/**
 * 189. Rotate Array
 **/
class Solution_189 {

    public static void main(String[] args) {
        Solution_189 s = new Solution_189();
        s.rotate(new int[]{1,2,3,4,5,6,7}, 3);

    }

    public void rotate(int[] nums, int k) {
        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            answer[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = answer[i];
        }
    }
}