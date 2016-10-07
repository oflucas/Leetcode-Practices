// Total Accepted: 150227
// Total Submissions: 356183
// Difficulty: Easy
// 0ms 100%

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        for (ListNode next = null; head != null; head = next) {
            next = head.next;
            head.next = prev;
            prev = head;
        }
        return prev;
    }
}