// 78_Subsets.java
// 2ms 97% Total Accepted: 102321 Total Submissions: 315786 Difficulty: Medium
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length, m = 1 << n;
        List<List<Integer>> ans = new ArrayList();
        for (int i = 0; i < m; i++) {
            List<Integer> cur = new ArrayList();
            for (int j = 0, f = 1; f <= i; f <<= 1, j++)
                if ((f & i) != 0) cur.add(nums[j]);
            ans.add(cur);
        }
        return ans;
    }
}
