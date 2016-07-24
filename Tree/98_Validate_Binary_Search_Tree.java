// Total Accepted: 102470
// Total Submissions: 480610
// Difficulty: Medium
// 1ms 100%

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
    public boolean isValidBST(TreeNode root) {
        return isVal(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isVal(TreeNode r, long L, long H) {
        if (r == null) return true;
        return r.val < H && r.val > L && isVal(r.left, L, r.val) && isVal(r.right, r.val, H);
    }
}