//5ms 10% Total Accepted: 52175 Total Submissions: 176842 Difficulty: Easy
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
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<Integer> path = new LinkedList();
        List<String> ans = new LinkedList();
        dfs(root, path, ans);
        return ans;
    }
    
    private void dfs(TreeNode r, LinkedList<Integer> path, List<String> ans) {
        if (r == null) return;
        path.add(r.val);
        if (r.left == null && r.right == null)
            ans.add(ListToString(path));
        else {
            dfs(r.left, path, ans);
            dfs(r.right, path, ans);
        }
        path.removeLast();
    }
    
    private String ListToString(LinkedList<Integer> path) {
        StringBuilder sb = new StringBuilder();
        boolean head = true;
        for (Integer i : path)
            if (head) {
                sb.append(i);
                head = false;
            } else
                sb.append("->").append(i);
        return sb.toString();
    }
}
