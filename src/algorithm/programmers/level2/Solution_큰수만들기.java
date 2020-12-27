package algorithm.programmers.level2;


import java.util.ArrayList;
import java.util.Stack;

public class Solution_큰수만들기 {
    public String solution(String number, int k) {
        boolean[] check = new boolean[number.length()];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < number.length(); i++) {
            while (!stack.isEmpty()){
                if(number.charAt(i) > number.charAt(stack.peek())){
                    k--;
                    int index = stack.pop();
                    check[index] = true;
                }else {
                    break;
                }
                if(k == 0){
                    i = number.length();
                    break;
                }
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < check.length - k; i++) {
            if(!check[i]) {
                sb.append(number.charAt(i));
            }
        }


        return sb.toString();
    }
}
