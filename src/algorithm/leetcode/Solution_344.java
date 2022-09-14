package algorithm.leetcode;


import java.util.Arrays;

/**
 * 344. Reverse String
 **/
class Solution_344 {

    public static void main(String[] args) {
        Solution_344 s = new Solution_344();
        char[] s1 = {'a', 'b', 'c', 'd', 'e'};
        s.reverseString(s1);
        System.out.println(Arrays.toString(s1));
    }

    public void reverseString(char[] s) {

        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;

        }
    }
}