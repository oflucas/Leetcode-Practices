//25_Reverse_Nodes_in_k-Group.java
//2ms 10% Total Accepted: 62641 Total Submissions: 223715 Difficulty: Hard
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dmy = new ListNode(0);
        dmy.next = head;
        ListNode prev = dmy, cur = head;
        int n = 0;
        for (ListNode i = head; i != null; i = i.next) n++;
        
        for (int u = 0; u < n / k; u++) {
            for (int j = 1; j < k; j++) {
                ListNode tmp = cur.next.next;
                cur.next.next = prev.next;
                prev.next = cur.next;
                cur.next = tmp;
            }
            prev = cur;
            cur = cur.next;
        }
        return dmy.next;
    }
}
