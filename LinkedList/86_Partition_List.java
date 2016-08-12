// Total Accepted: 73427
// Total Submissions: 241449
// Difficulty: Medium
// 1ms 99%

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode more = new ListNode(0), less = new ListNode(0), i = more, j = less;
        for (ListNode r = head; r != null; r = r.next)
            if (r.val < x) {
                j.next = r;
                j = r;
            } else {
                i.next = r;
                i = r;
            }
        
        i.next = null;
        j.next = more.next;
        return less.next;
    }
}