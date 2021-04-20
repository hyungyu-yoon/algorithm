package algorithm.programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_프린터 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Doc> q = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            q.add(new Doc(i,priorities[i]));
        }

        int order = 1;
        while (!q.isEmpty()) {
            Doc doc = q.poll();



            boolean check = false;
            for (int i = 0; i < q.size(); i++) {
                Doc doc2 = q.poll();
                if(doc.priority < doc2.priority) {
                    check = true;
                }
                q.add(doc2);
            }



            if(check) {
                q.add(doc);
            }else {
                if(doc.location == location) {
                    answer = order;
                    break;
                }
                order++;
            }
        }

        return answer;
    }

    class Doc {
        int location;
        int priority;

        Doc(int l, int p) {
            this.location = l;
            this.priority = p;
        }
    }
}
