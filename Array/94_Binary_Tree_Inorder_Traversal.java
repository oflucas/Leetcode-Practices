// 94_Binary_Tree_Inorder_Traversal.java
// 2ms 10% Total Accepted: 131088 Total Submissions: 324422 Difficulty: Medium
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
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode p = root;
        Stack<TreeNode> st = new Stack();
        List<Integer> ans = new ArrayList();
        
        do {
            if (p != null) {
                while (p.left != null) {
                    st.push(p);
                    p = p.left;
                }
                ans.add(p.val); //System.out.println(p.val);
                if (p.right != null) {
                    st.push(p);
                    p = p.right;
                    continue;
                }
            }
            while (!st.empty() && p == st.peek().right)
                p = st.pop();
            if (!st.empty()) { // p is st.peek's left child
                ans.add(st.peek().val); //System.out.println(st.peek().val);
                p = st.peek().right;
            }
        } while (!st.empty());
        
        return ans;
    }
}
