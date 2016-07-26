// Total Accepted: 89517
// Total Submissions: 281156
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
    public void flatten(TreeNode root) {
        flt(root);
    }

    private TreeNode flt(TreeNode r) {
    	// return flattened linked list tail node
    	if (r == null) return null;
    	
    	TreeNode rch_tail = flt(r.right), lch_tail = flt(r.left);
    	if (rch_tail == null && lch_tail == null) 
    		return r;
    	
    	if (lch_tail != null) {
    		TreeNode rch = r.right;
    		r.right = r.left;
    		r.left = null;
    		lch_tail.right = rch;
    	}

    	return (rch_tail == null) ? lch_tail : rch_tail;
    }
}