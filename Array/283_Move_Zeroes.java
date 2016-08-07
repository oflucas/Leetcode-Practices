// Total Accepted: 104238
// Total Submissions: 228449
// Difficulty: Easy
// 1ms 88%

public class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0, n = nums.length;
        for (int i : nums)
            if (i != 0) nums[j++] = i;
        for (; j < n; nums[j++] = 0);        
    }
}