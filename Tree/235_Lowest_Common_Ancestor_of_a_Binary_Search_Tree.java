// Total Accepted: 85014
// Total Submissions: 226140
// Difficulty: Easy
// 11ms 20%

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] ans = new TreeNode[1];
        lca(Integer.MIN_VALUE, Integer.MAX_VALUE, root, p, q, ans);
        return ans[0];
    }
    
    private int lca(int bot, int top, TreeNode r, TreeNode p, TreeNode q, TreeNode[] ans) {
        if (r == null) return 0;
        if ((p.val > top || p.val < bot) && (q.val > top || q.val < bot)) return 0;
        int n1 = lca(bot, r.val, r.left, p, q, ans), n2 = lca(r.val, top, r.right, p, q, ans);
        if (n1 > 1 || n2 > 1) return 2;
        int n = n1 + n2 + ((r == p || r == q) ? 1 : 0);
        if (n > 1) ans[0] = r;
        return n;
    }
}