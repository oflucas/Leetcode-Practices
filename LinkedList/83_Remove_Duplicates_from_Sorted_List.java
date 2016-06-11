/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        for (ListNode i = head, j = i; i != null; i.next = j, i = i.next)
            for (j = i.next; j != null && j.val == i.val; j = j.next);
        return head;
    }
}

// 1ms
