package algorithm.programmers.level3;

import java.util.HashSet;
import java.util.Set;

/**
 * 카카오 인턴십 문제
 */
public class Solution_불량사용자 {
    static Set<Set<String>> set = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {

        permutation(user_id, banned_id, 0, user_id.length, banned_id.length);

        return set.size();
    }

    void permutation(String[] user_id, String[] banned_id, int depth, int n, int r) {
        if (depth == r) {
            boolean check = true;
            Set<String> userSet = new HashSet<>();
            for (int i = 0; i < r; i++) {
                userSet.add(user_id[i]);
                if (!isBannedUser(user_id[i], banned_id[i])) {
                    check = false;
                    break;
                }
            }

            if (set.contains(userSet)) {
                return;
            }

            if (check) {
                set.add(userSet);
            }


            return;
        }

        for (int i = depth; i < n; i++) {
            swap(user_id, depth, i);
            permutation(user_id, banned_id, depth + 1, n, r);
            swap(user_id, depth, i);
        }
    }

    void swap(String[] arr, int depth, int i) {
        String temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    public boolean isBannedUser(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }

        boolean equal = true;
        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) == '*') {
                continue;
            }
            if (userId.charAt(i) != bannedId.charAt(i)) {
                equal = false;
                break;
            }
        }
        return equal;
    }
}
