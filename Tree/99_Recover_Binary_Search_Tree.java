// Total Accepted: 56750
// Total Submissions: 207150
// Difficulty: Hard
// 6ms 26%

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
    public void recoverTree(TreeNode r) {
        TreeNode[] rec = new TreeNode[3];
        while (r != null) {
            if (r.left != null) {
                TreeNode t = r.left;
                while (t.right != r && t.right != null) t = t.right;
                if (t.right != null) {  // left children visited
                    update(r, rec);
                    t.right = null;
                    r = r.right;
                } else {    // visit left children
                    t.right = r;
                    r = r.left;
                }
            } else {    // no left children, visit r itself and then right children
                update(r, rec);
                r = r.right;
            }
        }
        
        // swap
        int tmp = rec[1].val;
        rec[1].val = rec[2].val;
        rec[2].val = tmp;
    }
    
    private void update(TreeNode r, TreeNode[] rec) {
        //System.out.println(r.val);
        if (rec[0] != null && rec[0].val > r.val) {
            if (rec[1] == null) rec[1] = rec[0];
            rec[2] = r;
        }
        rec[0] = r;
    }
}