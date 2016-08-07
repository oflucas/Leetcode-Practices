// Total Accepted: 70808
// Total Submissions: 300504
// Difficulty: Medium
// 2ms 100%

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        
        ListNode dmyHead = new ListNode(-1), mid = dmyHead;
        dmyHead.next = head;
        
        // find middle node
        for (ListNode i = dmyHead; i != null && i.next != null; i = i.next.next)
            mid = mid.next;
        
        // get the other half of linkedlist
        ListNode half = mid.next, next = half.next;
        mid.next = null;
        half.next = null;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = half;
            half = next;
            next = tmp;
        }
        
        // needle head and half
        for (ListNode i = head, j = half, pre = dmyHead; i != null; ) {
            pre.next = i;
            ListNode nexti = i.next;
            i.next = j;
            pre = j;
            i = nexti;
            j = j != null ? j.next : null;
        }
        
    }
}