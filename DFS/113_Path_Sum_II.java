// Total Accepted: 88704
// Total Submissions: 303800
// Difficulty: Medium
// 4ms 50%

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new LinkedList();
        findSum(root, sum, new LinkedList(), ans);
        return ans;
    }
    
    private void findSum(TreeNode r, int sum, List<Integer> cur, List<List<Integer>> ans) {
        if (r == null) return;
        
        cur.add(r.val);
        if (r.left == null && r.right == null && r.val == sum)
            ans.add(new LinkedList(cur));
        else {
            findSum(r.left, sum - r.val, cur, ans);
            findSum(r.right, sum - r.val, cur, ans);
        }
        cur.remove(cur.size() - 1);
    }
}