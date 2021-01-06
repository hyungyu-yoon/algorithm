package algorithm.programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_수식최대화 {

    public long solution(String expression) {
        long answer = 0;

        char[][] combi = {{'+', '-', '*'}, {'+', '*', '-'}, {'-', '+', '*'}, {'-', '*', '+'}, {'*', '+', '-'}, {'*', '-', '+'}};
        List<Long> num = Arrays.stream(expression.split("[+*-]")).map(Long::parseLong).collect(Collectors.toList());
        List<Character> op = new LinkedList<>();

        for (int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) - '0' < 0 ){
                op.add(expression.charAt(i));
            }
        }

        for (char[] arr : combi) {
            answer = Math.max(answer, calc(arr, new LinkedList<>(num), new LinkedList<>(op)));
        }
        return answer;
    }

    public long calc(char[] arr, List<Long> num, List<Character> op) {
        for (char c : arr) {
            for (int i = 0; i < op.size(); i++) {
                if (c == op.get(i)) {
                    if(c == '+'){
                        num.set(i, num.get(i) + num.remove(i + 1));
                    }else if(c == '-'){
                        num.set(i, num.get(i) - num.remove(i + 1));
                    }
                    else if(c == '*'){
                        num.set(i, num.get(i) * num.remove(i + 1));
                    }
                    op.remove(i);
                    i--;
                }
            }
        }

        return Math.abs(num.get(0));
    }

    public static void main(String[] args) {
        String expression = "100-200*300-500+20";

        Solution_수식최대화 s = new Solution_수식최대화();
        System.out.println(s.solution(expression));
    }
}
