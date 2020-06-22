package algorithm.programmers.level1;

public class Solution_최대공약수와최대공배수 {
	public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        answer[0] = n > m ? gcd(n,m) : gcd(m,n);
        answer[1] = n*m/answer[0];
        return answer;
    }
    
    public int gcd(int a,int b){
        if(a % b == 0)
            return b;
        return gcd(b,a%b);
    }
}
