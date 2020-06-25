package algorithm.programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution_실패율 {
	public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];

		int[] challenge = new int[N+1];
		int[] clear = new int[N+1];
	
		for (int i = 0; i < stages.length; i++) {
			if(stages[i] <= N) {
				challenge[stages[i]]++;
                clear[stages[i]]++;
			}
			for (int j = 1; j < stages[i]; j++) {
				clear[j]++;
			}
		}
		
		List<Stage> s = new ArrayList<>();
		for (int i = 1; i < clear.length; i++) {
			if(challenge[i] == 0 || clear[i] == 0) {
				s.add(new Stage(i, 0.0 ));
			}else {
				s.add(new Stage(i, (double) challenge[i]/clear[i] ));
			}
			
		}
		
		Collections.sort(s);
		System.out.println(s);
		for (int i = 0; i < s.size(); i++) {
			answer[i] = s.get(i).number;
		}
		
		return answer;
	}
	
	static class Stage implements Comparable<Stage>{
		int number;
		double fail;
		Stage(int number, double fail){
			this.number = number;
			this.fail = fail;
		}
		
		@Override
		public int compareTo(Stage o) {
			if (this.fail == o.fail) {
	            return Integer.compare(this.number, o.number);
	        }
	        return -Double.compare(this.fail, o.fail);
		}
	}
	
}
