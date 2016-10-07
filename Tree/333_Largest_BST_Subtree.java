// Total Accepted: 7569
// Total Submissions: 26288
// Difficulty: Medium
// 7ms 6%

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
    public int largestBSTSubtree(TreeNode root) {
        int[] ans = new int[1];
        HashMap<TreeNode, int[]> h = new HashMap();
        // index 0,1,2 ~> BST subtree smallest value, largest value, size
        h.put(null, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0});
        findBST(root, h, ans);
        return ans[0];
    }
    
    private boolean findBST(TreeNode root, HashMap<TreeNode, int[]> h, int[] ans) {
        if (root == null)
            return true;
        
        boolean a = findBST(root.left, h, ans), b = findBST(root.right, h, ans);
        if (!a || !b)
            return false;
        
        int[] l = h.get(root.left), r = h.get(root.right);
        if (l[1] > root.val || r[0] < root.val)
            return false;
        
        h.put(root, new int[]{Math.min(root.val, l[0]), Math.max(root.val, r[1]), l[2] + r[2] + 1});
        //System.out.println(root.val + ":    " + h.get(root)[0] + ", " + h.get(root)[1] + ", " + h.get(root)[2]);
        ans[0] = Math.max(ans[0], l[2] + r[2] + 1);
        return true;
    }
}