package algorithm.leetcode;


import java.util.Arrays;
import java.util.Stack;

/**
 * 977. Squares of a Sorted Array
 **/
class Solution_977 {

    public static void main(String[] args) {


    }

    public int[] sortedSquares(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}