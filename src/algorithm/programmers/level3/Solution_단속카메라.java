package algorithm.programmers.level3;

import java.util.Arrays;

public class Solution_단속카메라 {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (o1,o2) -> Integer.compare(o1[0],o2[0]));

        int preExit = routes[0][1];
        answer = 1;
        for (int i = 1, s = routes.length; i < s; i++) {
            int entrance = routes[i][0];
            int exit = routes[i][1];

            if(preExit < entrance){
                preExit = exit;
                answer++;
                continue;
            }

            if(exit < preExit){
                preExit = exit;
            }
        }

        return answer;
    }
}
