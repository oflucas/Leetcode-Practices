// Total Accepted: 115401
// Total Submissions: 337918
// Difficulty: Easy
// 3ms 54ms


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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        List<List<TreeNode>> q = new ArrayList();
        if (root == null)
            return ans;
        q.add(new ArrayList(Collections.singleton(root)));
        for (int i = 0; i < q.size(); i++) {
            List<TreeNode> cur = q.get(i), next = new ArrayList();
            List<Integer> cur_v = new ArrayList();
            for (TreeNode j : cur) {
                cur_v.add(j.val);
                if (j.left != null) next.add(j.left);
                if (j.right != null) next.add(j.right);
            }
            ans.add(cur_v);
            if (next.size() > 0)
                q.add(next);
        }
        return ans;
    }
}