// Total Accepted: 130650
// Total Submissions: 306014
// Difficulty: Easy
// 2ms 80%

public class Solution {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int cnt = 1, cand = nums[0];
        for (int i = 1; i < nums.length; i++)
            if (cand == nums[i])
                cnt++;
            else
            if (cnt-- == 0) {
                cnt = 1;
                cand = nums[i];
            }
        
        return cand;
    }
}