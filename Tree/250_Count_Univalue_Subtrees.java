// Total Accepted: 7876
// Total Submissions: 20666
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
    public int countUnivalSubtrees(TreeNode root) {
        int[] cnt = new int[1];
        isUni(root, cnt);
        return cnt[0];
    }
    
    private boolean isUni(TreeNode r, int[] cnt) {
        if (r == null) return true;
        boolean a = !isUni(r.left, cnt), b = !isUni(r.right, cnt), notUni = a || b || (r.left != null && r.left.val != r.val)  || (r.right != null && r.right.val != r.val);
        cnt[0] += notUni ? 0 : 1;
        return !notUni;
    }
}