// 1ms 100% Total Accepted: 107730 Total Submissions: 340751 Difficulty: Easy
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) 
            return sum == root.val;
        if (root.left != null && hasPathSum(root.left, sum - root.val))
            return true;
        if (root.right != null && hasPathSum(root.right, sum - root.val))
            return true;
        return false;
    }
}
