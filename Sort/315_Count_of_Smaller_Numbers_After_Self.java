// 315_Count_of_Smaller_Numbers_After_Self.java
// 10ms 88% Total Accepted: 12712 Total Submissions: 40532 Difficulty: Hard
public class Solution {
    private class SortNode {
        int val, cntLess, dup;
        SortNode left, right;
        
        public SortNode(int v, int n, int d) {
            val = v;
            cntLess = n;
            dup = d;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] ans = new Integer[n];
        if (n < 1) return Arrays.asList(ans);
        
        SortNode root = new SortNode(nums[n - 1], 0, 1);
        ans[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            SortNode prev = null, cur = root;
            int m = 0;
            while (cur != null && nums[i] != cur.val) {
                prev = cur;     //System.out.println(nums[i] + ": " + cur.val);
                if (nums[i] > cur.val) {
                    m += cur.cntLess + cur.dup;
                    cur = cur.right;
                } else {
                    cur.cntLess++;
                    cur = cur.left;
                }
            }
            
            if (cur == null) { // ends at a potential leaf
                cur = new SortNode(nums[i], 0, 1);
                if (cur.val > prev.val) prev.right = cur; else prev.left = cur;
            } else { // ends up with equal
                cur.dup++;
                m += cur.cntLess;
            }
            
            ans[i] = m;
        }
        
        return Arrays.asList(ans);
    }
}
