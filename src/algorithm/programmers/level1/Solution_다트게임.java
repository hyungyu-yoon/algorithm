package algorithm.programmers.level1;

import java.util.Arrays;

public class Solution_다트게임 {
    public int solution(String dartResult) {
        int answer = 0;

        int[] score = new int[3];
        int[] bonus = new int[3];
        int[] option = new int[3];
        Arrays.fill(option, 1);

        int index = -1;
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if (c >= '0' && c <= '9') {
                index++;
                score[index] = c - '0';

                if (c == '1' && (i + 1 < dartResult.length() - 1 && dartResult.charAt(i + 1) == '0')) {
                    score[index] = 10;
                    i++;
                    continue;
                }
            }

            if (c == 'S') {
                bonus[index] = 1;
            } else if (c == 'D') {
                bonus[index] = 2;
            } else if (c == 'T') {
                bonus[index] = 3;
            } else if (c == '*') {
                if (index > 0) {
                    option[index - 1] *= 2;
                }
                option[index] *= 2;
            } else if (c == '#') {
                option[index] *= -1;
            }
        }

        for (int i = 0; i < 3; i++) {
            answer += Math.pow(score[i], bonus[i]) * option[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution_다트게임 s = new Solution_다트게임();

        s.solution("1S*2T*3S");
    }
}
