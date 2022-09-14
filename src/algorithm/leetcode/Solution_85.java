package algorithm.leetcode;


import java.util.Stack;

/**
 * 85. Maximal Rectangle
 **/
class Solution_85 {

    public static void main(String[] args) {
        Solution_85 solution_85 = new Solution_85();

        System.out.println(solution_85.maximalRectangle(new char[][]{{'1','1','0','1'}, {'1','1','0','1'}, {'1','1','1','1'}}));
        
    }

    public int maximalRectangle(char[][] matrix) {

        Stack<Integer> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                int count = 0;
                for (int k = i; k >= 0; k--) {
                    if (matrix[k][j] == '1') {
                        count++;
                        continue;
                    }

                    break;
                }
                stack.push(count);
            }

            int min = Integer.MAX_VALUE;
            int length = 0;
            while (!stack.isEmpty()) {
                int pop = stack.pop();

                if (pop == 0) {
                    min = Integer.MAX_VALUE;
                    length = 0;
                    continue;
                }

                if (pop > 0) {
                    length++;
                }

                min = Math.min(min, pop);

                answer = Math.max(answer, length * min);
            }
        }

        return answer;
    }
}