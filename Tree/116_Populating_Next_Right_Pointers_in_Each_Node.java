// Total Accepted: 96668
// Total Submissions: 263639
// Difficulty: Medium
// 0ms 100%

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        for (TreeLinkNode i = root; i != null && i.left != null; i = i.left) {
            i.left.next = i.right;
            for (TreeLinkNode pre = i, j = i.next; j != null; pre = j, j = j.next) {
                pre.right.next = j.left;
                j.left.next = j.right;
            }
        }
    }
}