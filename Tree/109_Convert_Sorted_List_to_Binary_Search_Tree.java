// Total Accepted: 78649
// Total Submissions: 249560
// Difficulty: Medium
// 1ms 100%

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode pre = null, i1 = head, i2 = head;
        for (; i2 != null && i2.next != null; pre = i1, i1 = i1.next, i2 = i2.next.next);
        
        TreeNode r = new TreeNode(i1.val);
        if (pre != null) {
            pre.next = null;
            r.left = sortedListToBST(head);
        }
        r.right = sortedListToBST(i1.next);
        return r;
    }
}