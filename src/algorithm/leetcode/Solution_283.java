package algorithm.leetcode;


/**
 * 283. Move Zeroes
 **/
class Solution_283 {

    public static void main(String[] args) {

    }

    public void moveZeroes(int[] nums) {

        int i = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[i++] = num;
            }
        }

        for (int j = i; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}