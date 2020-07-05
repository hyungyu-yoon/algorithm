package algorithm.programmers.level2;

class Solution_탑 {
	public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        
        for (int i = heights.length -1 ; i >= 0; i--) {
			for (int j = i-1; j >= 0; j--) {
				if(heights[i] < heights[j]) {
					answer[i] = j;
					break;
				}
			}
		}
        
        return answer;
    }
}