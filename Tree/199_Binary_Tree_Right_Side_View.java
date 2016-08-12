// Total Accepted: 50537
// Total Submissions: 138702
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList();
        traverse(root, 0, ans);
        return ans;
    }
    
    private void traverse(TreeNode r, int depth, List<Integer> ans) {
        if (r == null) return;
        if (depth >= ans.size())
            ans.add(r.val);
        traverse(r.right, depth + 1, ans);
        traverse(r.left, depth + 1, ans);
    }
}