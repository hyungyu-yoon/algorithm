package algorithm.swexpertacademy.swtest;

import java.io.*;
import java.util.*;


public class Solution_5658_보물상자비밀번호{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			
			
			ArrayList<Character> p = new ArrayList<>();
			String number = br.readLine();

			for (int i = 0; i < N; i++) {
				p.add(number.charAt(i));
			}

			TreeMap<Integer, Boolean> map = new TreeMap<>();
			int count = N/4;
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < count; i++) {
				if(i != 0) {
					p.add(0,p.remove(N - 1));
				}
				
				for (int j = 0; j < 4; j++) {
					for (int k = 0; k < count; k++) {
						sb.append(p.get(j*count + k));
					}
					
					map.put(Integer.parseInt(sb.toString(),16), true);
					sb.setLength(0);
				}
			}
			K = map.size() - K + 1;
			for(int i : map.keySet()) {
				K--;
				if(K == 0) {
					System.out.println("#" +tc + " " + i);
				}
			}
		}
	}

}
