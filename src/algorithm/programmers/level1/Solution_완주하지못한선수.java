package algorithm.programmers.level1;

import java.util.HashMap;

public class Solution_완주하지못한선수 {
	public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for (int i = 0; i < participant.length; i++) {
        	if(map.containsKey(participant[i])) {
        		map.put(participant[i], map.get(participant[i]) + 1);
        	}else {
        		map.put(participant[i], 1);
        	}
        }
        
        for (int i = 0; i < completion.length; i++) {
			int count = map.get(completion[i]);
			if(count == 1) {
				map.remove(completion[i]);
			}else {
				map.put(completion[i], count - 1);
			}
		}
        
        for(String str : map.keySet()) {
        	answer = str;
        }
        
        return answer;
    }
}
