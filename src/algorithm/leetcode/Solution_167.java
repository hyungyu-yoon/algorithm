package algorithm.leetcode;


import java.util.Arrays;

/**
 * 167. Two Sum II - Input Array Is Sorted
 **/
class Solution_167 {

    public static void main(String[] args) {

        Solution_167 s = new Solution_167();
        System.out.println(Arrays.toString(s.twoSum(new int[]{-1, 0}, -1)));
    }

    public int[] twoSum(int[] numbers, int target) {

        for (int i = 0; i < numbers.length; i++) {

            for (int j = i + 1; j < numbers.length; j++) {

                if (numbers[i] + numbers[j] > target) {
                    break;
                }

                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }

        return null;
    }
}