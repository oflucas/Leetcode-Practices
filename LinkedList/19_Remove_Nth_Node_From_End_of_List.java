// 1ms 95% Total Accepted: 114403 Total Submissions: 381012 Difficulty: Easy
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dmy = new ListNode(0), pre = dmy;
        dmy.next = head;
        int m = 0;
        for (ListNode i = head; i != null; i = i.next) m++;
        for (int i = 0; i < m - n; i++) pre = pre.next;
        pre.next = pre.next.next;
        return dmy.next;
    }
}
