// Total Accepted: 3466
// Total Submissions: 6395
// Difficulty: Medium
// 3ms 7%


public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList();
        HashMap<TreeNode, TreeNode> parent = new HashMap();
        List<TreeNode> cur = new ArrayList();
        trav(root, cur, parent);
        
        while (cur.size() > 0) {
            List<Integer> l = new ArrayList();
            List<TreeNode> next = new ArrayList();
            for (TreeNode i : cur) {
                l.add(i.val);
                if (!parent.containsKey(i)) continue;
                TreeNode p = parent.get(i);
                if (i == p.left) p.left = null; else p.right = null;
                if (p.left == null && p.right == null)
                    next.add(p);
            }
            ans.add(l);
            cur = next;
        }
        return ans;
    }
    
    private void trav(TreeNode r, List<TreeNode> cur, HashMap<TreeNode, TreeNode> parent) {
        if (r == null) return;
        if (r.left == null && r.right == null) {
            cur.add(r);
            return;
        }
        if (r.left != null) {
            parent.put(r.left, r);
            trav(r.left, cur, parent);
        }
        if (r.right != null) {
            parent.put(r.right, r);
            trav(r.right, cur, parent);
        }
    }

///////////////////////////////////////////////////////////////////////////////
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findLeaves_bestSol(TreeNode root) {
        helper(root);
        return res;
    }
    private int helper(TreeNode node){
        if(null==node)  return -1;
        int height= 1 + Math.max(helper(node.left), helper(node.right));
        if(res.size()<height+1)  res.add(new ArrayList<Integer>());
        res.get(height).add(node.val);
        // if need to actually remove the leaves, uncomment next line
        // node.left = node.right = null;
        return height;
    }


}