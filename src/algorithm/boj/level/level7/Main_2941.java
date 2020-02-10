package algorithm.boj.level.level7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2941 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		s = s.replaceAll("c=", " ");
		s = s.replaceAll("c-", " ");
		s = s.replaceAll("dz=", " ");
		s = s.replaceAll("d-", " ");
		s = s.replaceAll("lj", " ");
		s = s.replaceAll("nj", " ");
		s = s.replaceAll("s=", " ");
		s = s.replaceAll("z=", " ");
		
		System.out.println(s.length());
	}
}
