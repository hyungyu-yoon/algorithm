package algorithm.swexpertacademy.d4;
import java.util.Scanner;
 
public class Solution_5432_쇠막대기자르기{
 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         
        int t = scanner.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            String str = scanner.next();
         
            int left = 0;
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '(') {
                    left++;
                }
                else {
                    if(str.charAt(i-1) == '(') {
                        left--;
                        sum += left;
                    }else {
                        sum++;
                        left--;
                    }
                }
            }
            System.out.println("#" + tc + " " + sum);
        }
    }
}
