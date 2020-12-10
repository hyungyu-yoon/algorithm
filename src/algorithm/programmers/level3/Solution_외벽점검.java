package algorithm.programmers.level3;


import java.util.*;
import java.util.stream.Collectors;

public class Solution_외벽점검 {
    private static int min;

    public int solution(int n, int[] weak, int[] dist) {
        int answer = 0;

        List<Integer> list = Arrays.stream(weak).boxed().collect(Collectors.toList());
        min = Integer.MAX_VALUE;

        for (int j = 0; j < list.size(); j++) {
            for (int i = 1; i <= dist.length; i++) {
                permutation(list, dist, 0, dist.length, i);
            }
            list.add(list.remove(0) + n);
        }
        answer = min == Integer.MAX_VALUE ? -1 : min;
        return answer;
    }

    void permutation(List<Integer> list, int[] dist, int depth, int n, int r) {
        if (depth == r) {
            boolean check = true;
            int index = 0;
            int d = dist[index];
            int sum = 0;
            for (int i = 1; i < list.size(); i++) {
                sum += list.get(i) - list.get(i - 1);
                if (sum <= d) {
                    continue;
                }
                index++;

                if (index >= r) {
                    check = false;
                    break;
                }
                d = dist[index];
                sum = 0;
            }

            if (check) {
                min = Math.min(min, r);
            }
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(dist, depth, i);
            permutation(list, dist, depth + 1, n, r);
            swap(dist, depth, i);
        }
    }

    void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {

        Solution_외벽점검 s = new Solution_외벽점검();
        int i = s.solution(12, new int[]{1, 5, 6, 10}, new int[]{1, 2, 3, 4});
        System.out.println(i);
    }

}
