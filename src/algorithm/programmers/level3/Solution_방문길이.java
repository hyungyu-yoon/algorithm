package algorithm.programmers.level3;

import java.util.HashSet;
import java.util.Set;

public class Solution_방문길이 {
    public int solution(String dirs) {
        int[][] map = new int[11][11];
        Set<String> set = new HashSet<>();
        int x = 5;
        int y = 5;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            int tx = x;
            int ty = y;
            if(c == 'L'){
                ty--;
            }else if(c == 'R'){
                ty++;
            }else if(c == 'U'){
                tx--;
            }else {
                tx++;
            }

            if(tx < 0 || tx > 10 || ty < 0 || ty > 10){
                continue;
            }
            if(x > tx){
                sb.append(tx).append(x);
            }else {
                sb.append(x).append(tx);
            }

            if(y > ty){
                sb.append(ty).append(y);
            }else {
                sb.append(y).append(ty);
            }
            set.add(sb.toString());
            x = tx;
            y = ty;
            sb.setLength(0);
        }

        return set.size();
    }
}
