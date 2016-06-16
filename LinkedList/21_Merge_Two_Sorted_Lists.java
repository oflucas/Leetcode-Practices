// 1ms 100% Total Accepted: 133564 Total Submissions: 371843 Difficulty: Easy
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dmy = new ListNode(0);
        for (ListNode prev = dmy; l1 != null || l2 != null; prev = prev.next)
            if (l1 == null || (l2 != null && l2.val < l1.val)) {
                prev.next = l2; l2 = l2.next;
            } else {
                prev.next = l1; l1 = l1.next;
            }
         return dmy.next;
    }
}
