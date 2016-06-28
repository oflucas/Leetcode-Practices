// 270_Closest_Binary_Search_Tree_Value.java
// 0ms 100% Total Accepted: 13954 Total Submissions: 39782 Difficulty: Easy
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
    public int closestValue(TreeNode root, double target) {
        if (root == null) return Integer.MIN_VALUE;
        int cand = root.val;
        if (root.left != null && target < root.val) {
            int t = closestValue(root.left, target);
            if (Math.abs(target - t) < Math.abs(target - cand))
                cand = t;
        }
        if (root.right != null && target > root.val) {
            int t = closestValue(root.right, target);
            if (Math.abs(target - t) < Math.abs(target - cand))
                cand = t;
        }
        return cand;
    }
}
