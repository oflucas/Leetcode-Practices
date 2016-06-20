//1ms 100% Total Accepted: 75543 Total Submissions: 277261 Difficulty: Medium
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
        int black = Integer.MIN_VALUE;
        ListNode dmyHead = new ListNode(0), pre = dmyHead;
        for (ListNode i = head; i != null; i = i.next) 
            if (i.val != black) {
                if (i.next != null && i.next.val == i.val)
                    black = i.val;
                else {
                    pre.next = i;
                    pre = pre.next;
                }
            }
        pre.next = null;
        return dmyHead.next;
    }
}
