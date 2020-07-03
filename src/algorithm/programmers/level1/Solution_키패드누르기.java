package algorithm.programmers.level1;

public class Solution_키패드누르기 {
	public String solution(int[] numbers, String hand) {
		String answer = "";
		int[][] keypad = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 0, 11 } };
		int[][] location = { { 3, 0 }, { 3, 2 } };

		StringBuilder sb = new StringBuilder();
		int lenL = 0;
		int lenR = 0;
		for (int i = 0; i < numbers.length; i++) {

			switch (numbers[i]) {
			case 1:
				location[0][0] = 0;
				location[0][1] = 0;
				sb.append("L");
				break;
			case 4:
				location[0][0] = 1;
				location[0][1] = 0;
				sb.append("L");
				break;
			case 7:
				location[0][0] = 2;
				location[0][1] = 0;
				sb.append("L");
				break;
			case 3:
				location[1][0] = 0;
				location[1][1] = 2;
				sb.append("R");
				break;
			case 6:
				location[1][0] = 1;
				location[1][1] = 2;
				sb.append("R");
				break;
			case 9:
				location[1][0] = 2;
				location[1][1] = 2;
				sb.append("R");
				break;
			case 2:
				lenL = 1 - location[0][1] + location[0][0];
				lenR = Math.abs(1 - location[1][1]) + location[1][0];
				if (lenL < lenR) {
					location[0][0] = 0;
					location[0][1] = 1;
					sb.append("L");
				} else if (lenL > lenR) {
					location[1][0] = 0;
					location[1][1] = 1;
					sb.append("R");
				} else {
					if (hand.equals("left")) {
						location[0][0] = 0;
						location[0][1] = 1;
						sb.append("L");
					} else {
						location[1][0] = 0;
						location[1][1] = 1;
						sb.append("R");
					}
				}
				break;
			case 5:
				lenL = Math.abs(1 - location[0][1]) + Math.abs(1 - location[0][0]);
				lenR = Math.abs(1 - location[1][1]) + Math.abs(1 - location[1][0]);
				if (lenL < lenR) {
					location[0][0] = 1;
					location[0][1] = 1;
					sb.append("L");
				} else if (lenL > lenR) {
					location[1][0] = 1;
					location[1][1] = 1;
					sb.append("R");
				} else {
					if (hand.equals("left")) {
						location[0][0] = 1;
						location[0][1] = 1;
						sb.append("L");
					} else {
						location[1][0] = 1;
						location[1][1] = 1;
						sb.append("R");
					}
				}
				break;
			case 8:
				lenL = Math.abs(1 - location[0][1]) + Math.abs(2 - location[0][0]);
				lenR = Math.abs(1 - location[1][1]) + Math.abs(2 - location[1][0]);
				if (lenL < lenR) {
					location[0][0] = 2;
					location[0][1] = 1;
					sb.append("L");
				} else if (lenL > lenR) {
					location[1][0] = 2;
					location[1][1] = 1;
					sb.append("R");
				} else {
					if (hand.equals("left")) {
						location[0][0] = 2;
						location[0][1] = 1;
						sb.append("L");
					} else {
						location[1][0] = 2;
						location[1][1] = 1;
						sb.append("R");
					}
				}
				break;
			case 0:
				lenL = Math.abs(1 - location[0][1]) + Math.abs(3 - location[0][0]);
				lenR = Math.abs(1 - location[1][1]) + Math.abs(3 - location[1][0]);
				if (lenL < lenR) {
					location[0][0] = 3;
					location[0][1] = 1;
					sb.append("L");
				} else if (lenL > lenR) {
					location[1][0] = 3;
					location[1][1] = 1;
					sb.append("R");
				} else {
					if (hand.equals("left")) {
						location[0][0] = 3;
						location[0][1] = 1;
						sb.append("L");
					} else {
						location[1][0] = 3;
						location[1][1] = 1;
						sb.append("R");
					}
				}
				break;
			}

		}
		answer = sb.toString();
		return answer;
	}
}
