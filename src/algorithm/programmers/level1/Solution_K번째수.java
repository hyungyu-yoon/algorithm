package algorithm.programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

public class Solution_K번째수 {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		int i = 0, j = 0, k = 0;
		ArrayList<Integer> list = new ArrayList<>();
		int index = 0;
		for (int r = 0; r < commands.length; r++) {
			list.clear();
			i = commands[r][0] - 1;
			j = commands[r][1] - 1;
			k = commands[r][2] - 1;

			for (int l = i; l <= j; l++) {
				list.add(array[l]);
			}

			Collections.sort(list);
			answer[index++] = list.get(k);
		}
		return answer;
	}
	
	public static void main(String[] args) {
		Solution_K번째수 s = new Solution_K번째수();
		
		int[][] commands = {
				{2,5,3},
				{4,4,1},
				{1,7,3}
		};
		s.solution(new int[] {1,5,2,6,3,7,4}, commands);
	}
}
