// 101_Symmetric_Tree.java
// 1ms 100% Total Accepted: 114148 Total Submissions: 330577 Difficulty: Easy
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
    public boolean isSymmetric(TreeNode root) {
        return isSym(root, root);
    }
    
    private boolean isSym(TreeNode r1, TreeNode r2) {
        if (r1 == null || r2 == null) return r1 == r2;
        return r1.val == r2.val && isSym(r1.left, r2.right) && isSym(r1.right, r2.left);
    }
}
