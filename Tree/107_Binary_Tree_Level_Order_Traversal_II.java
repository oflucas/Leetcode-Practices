// Total Accepted: 88931
// Total Submissions: 253297
// Difficulty: Easy
// 4ms 40%

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<TreeNode>> h = new ArrayList();
        ArrayList<TreeNode> cur = new ArrayList(Collections.singletonList(root));

        while (cur.size() > 0) {
        	h.add(cur);
        	ArrayList<TreeNode> next = new ArrayList();
        	for (TreeNode i : cur) {
        		if (i.left != null) next.add(i.left);
        		if (i.right != null) next.add(i.right);
        	}
    		cur = next;
        }

        List<List<Integer>> ans = new ArrayList();
        for (int depth = h.size(), i = 0; i < depth; i++) {
        	List<Integer> y = new ArrayList();
        	for (TreeNode t : h.get(depth - 1 - i))
        		y.add(t.val);
        	ans.add(y);
        }

        return ans;
    }
}