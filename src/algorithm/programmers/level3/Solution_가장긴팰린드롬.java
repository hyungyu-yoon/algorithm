package algorithm.programmers.level3;

public class Solution_가장긴팰린드롬 {
    public int solution(String s) {
        for (int i = s.length(); i > 1; i--) {
            for (int j = 0; j  + i <= s.length(); j++) {
                boolean isPalin = true;
                for (int k = 0, l = i  / 2; k <= l; k++) {
                    if (s.charAt(j+k) != s.charAt(j + i - k - 1)) {
                        isPalin = false;
                        break;
                    }
                }

                if (isPalin) {
                    return i;
                }
            }
        }

        return 1;
    }

    public static void main(String[] args) {
        Solution_가장긴팰린드롬 s = new Solution_가장긴팰린드롬();
        System.out.println(s.solution("ABCCBA"));
    }
}
