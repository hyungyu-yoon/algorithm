package algorithm.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 21. Merge Two Sorted Lists
 */
class Solution_21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> valueList = new ArrayList<>();

        while (list1 != null) {
            valueList.add(list1.val);
            list1 = list1.next;
        }

        while (list2 != null) {
            valueList.add(list2.val);
            list2 = list2.next;
        }
        ListNode merge = null;
        ListNode answer = null;

        Collections.sort(valueList);

        for (Integer val : valueList) {
            ListNode node = new ListNode(val);
            if (merge == null) {
                merge = node;
                answer = merge;
            } else {
                merge.next = node;
                merge = merge.next;
            }
        }

        return answer;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}