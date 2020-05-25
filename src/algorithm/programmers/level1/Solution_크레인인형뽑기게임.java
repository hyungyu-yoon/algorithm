package algorithm.programmers.level1;

import java.util.Stack;

public class Solution_크레인인형뽑기게임 {
	public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        int N = board.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < moves.length; i++) {
			int number = moves[i] - 1;
			
			for (int j = 0; j < N; j++) {
				if(board[j][number] != 0) {
					int doll = board[j][number];
					board[j][number] = 0;
					
					if(!stack.isEmpty() && doll == stack.peek()) {
						answer += 2;
						stack.pop();
					}else {
						stack.add(doll);
					}
					break;
				}
			}
		}
        
        return answer;
    }
}
