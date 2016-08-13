// Total Accepted: 122331
// Total Submissions: 336218
// Difficulty: Easy
// 1ms 100%

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode i = head, j = head.next; 
        while (j != null) {
            if (i == j) return true;
            i = i.next;
            j = j.next;
            if (j != null) j = j.next;
        }
        return false;
    }
}