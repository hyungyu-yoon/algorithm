package algorithm.programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class Solution_3진법뒤집기 {
    public int solution(int n) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        while(n >= 3) {
            list.add(n%3);
            n/=3;
        }
        list.add(n);

        for (int i = 0; i < list.size(); i++) {
            answer += Math.pow(3, list.size()-i-1)*list.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution_3진법뒤집기 s = new Solution_3진법뒤집기();

        System.out.println(s.solution(45));
    }
}
