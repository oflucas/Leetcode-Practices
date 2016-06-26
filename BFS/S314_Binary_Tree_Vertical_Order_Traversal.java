//314_Binary_Tree_Vertical_Order_Traversal.java
//3ms 100% Total Accepted: 6612 Total Submissions: 21027 Difficulty: Medium
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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        ArrayList<TreeNode> q = new ArrayList();
        ArrayList<Integer> ofst = new ArrayList();
        List<List<Integer>> ans = new ArrayList();
        if (root == null) return ans;
        int bdMin = 0, bdMax = 0, i = 0;
        q.add(root); 
        ofst.add(0);
        for (; i < q.size(); i++) {
            int y = ofst.get(i);
            TreeNode r = q.get(i);
            bdMin = Math.min(bdMin, y); bdMax = Math.max(bdMax, y);
           
            if (r.left != null) {
                q.add(r.left);
                ofst.add(y - 1);
            }
            if (r.right != null) {
                q.add(r.right);
                ofst.add(y + 1);
            }
        }
        
        int m = bdMax - bdMin + 1;
        for (i = 0; i < m; i++) ans.add(new ArrayList());
        for (i = 0; i < q.size(); i++)
            ans.get(ofst.get(i) - bdMin).add(q.get(i).val);
        
        return ans;
    }
}
