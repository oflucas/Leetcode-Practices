// Total Accepted: 38872
// Total Submissions: 97709
// Difficulty: Medium
// 1ms 94%

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) 
            return head;
        ListNode even_head = head.next;
        ListNode[] tail = new ListNode[]{even_head, head};
        int odd = 1;
        for (ListNode i = head; i != null; odd = 1 - odd) {
            tail[odd] = i;
            ListNode next = i.next;
            if (next != null)
                i.next = next.next;
            i = next;
        }
        tail[1].next = even_head;
        tail[0].next = null;
        return head;
    }
}