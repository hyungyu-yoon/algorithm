package algorithm.programmers.level1;

import java.util.*;

public class Solution_두개뽑아서더하기 {
    public int[] solution(int[] numbers) {
        int[] answer = {};

        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }

        Iterator<Integer> iter = set.iterator();
        int[] array = new int[set.size()];
        int index = 0;
        while(iter.hasNext()) {
            array[index++] = iter.next();
        }
        return array;
    }
}
