package algorithm.programmers.level3;

import java.sql.Timestamp;

class Solution_추석트래픽 {
    public int solution(String[] lines){
        long S1 = 0L;

        long S2 = 0L;
        long T2 = 0L;

        int max = 0;
        for (int i = 0; i < lines.length; i++) {
            S1 = Timestamp.valueOf(lines[i].substring(0, lines[i].lastIndexOf(" "))).getTime();

            int count = 0;
            for (int j = i+1; j < lines.length; j++) {
                S2 = Timestamp.valueOf(lines[j].substring(0, lines[j].lastIndexOf(" "))).getTime();
                T2 = (long) Double.parseDouble(lines[j].substring(lines[j].lastIndexOf(" ")+1, lines[j].length()-2))*1000;

                if(S1 >= S2 - T2){
                    count++;
                }else {
                    max = Math.max(max, count);
                    break;
                }
            }
        }

        return max;
    }
}
