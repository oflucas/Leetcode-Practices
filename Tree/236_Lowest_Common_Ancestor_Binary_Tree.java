// Total Accepted: 52712
// Total Submissions: 182264
// Difficulty: Medium
// 12ms 97%

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
        lca(root, p, q, ans);
        return ans[0];
    }
    
    public int lca(TreeNode r, TreeNode p, TreeNode q, TreeNode[] ans) {
        if (r == null) return 0;
        int cl = lca(r.left, p, q, ans), cr = lca(r.right, p, q, ans), cnt = cl + cr;
        if (cl > 1 || cr > 1)
            return 2;
        
        if (r == p || r == q) cnt++;
        
        if (cnt > 1) ans[0] = r;
        return cnt;
    }
}