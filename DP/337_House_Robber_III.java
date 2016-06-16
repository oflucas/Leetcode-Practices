// 11ms, 32%, Total Accepted: 14562 Total Submissions: 38330 Difficulty: Medium
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
    public int rob(TreeNode root) {
        HashMap<TreeNode, Integer> rob = new HashMap(), noRob = new HashMap();
        rob.put(null, 0); noRob.put(null, 0);
        solve(root, rob, noRob);
        return Math.max(rob.get(root), noRob.get(root));
    }
    
    private void solve(TreeNode r, HashMap<TreeNode, Integer> rob, HashMap<TreeNode, Integer> noRob) {
        if (rob.containsKey(r)) return;
        solve(r.left, rob, noRob);
        solve(r.right, rob, noRob);
        int a = noRob.get(r.left), b = rob.get(r.left), c = noRob.get(r.right), d = rob.get(r.right);
        rob.put(r, a + c + r.val);
        noRob.put(r, Math.max(a, b) + Math.max(c, d));
    }
}
