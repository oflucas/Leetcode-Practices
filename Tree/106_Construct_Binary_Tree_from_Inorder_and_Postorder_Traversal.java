// 106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal.java
// 21ms 20% Total Accepted: 58388 Total Submissions: 198095 Difficulty: Medium
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return bdTree(0, 0, inorder.length, inorder, postorder);
    }
    
    private TreeNode bdTree(int iin, int ipo, int n, int[] ain, int[] apo) {
        if (n < 1) return null;
        int i = iin, v = apo[ipo + n - 1];
        for (; ain[i] != v; i++);
        TreeNode r = new TreeNode(v);
        r.left = bdTree(iin, ipo, i - iin, ain, apo);
        r.right = bdTree(i + 1, ipo + i - iin, n - (i - iin) - 1, ain, apo);
        return r;
    }
}
