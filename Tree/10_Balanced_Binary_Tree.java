//1ms 100% Total Accepted: 117029 Total Submissions: 339632 Difficulty: Easy
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
    public boolean isBalanced(TreeNode root) {
        return depth(root) >= 0;
    }
    
    private int depth(TreeNode r) {
        if (r == null) return 0;
        int d1 = depth(r.left);
        if (d1 < 0) return -1;
        int d2 = depth(r.right);
        if (d2 < 0 || Math.abs(d1 - d2) > 1) return -1;
        return Math.max(d1, d2) + 1;
    }
}
