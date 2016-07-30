// Total Accepted: 2844
// Total Submissions: 7342
// Difficulty: Medium
// 4ms ?%
// Follow up: limitation should be each number are allowed to be used only once, otherwise
// there will be infinite solutions. Given this limitation, DP can be used.

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] f = new int[target + 1];
        Arrays.sort(nums);
        int k = nums.length;
        f[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < k && nums[j] <= i; j++)
                f[i] += f[i - nums[j]];
        }
        return f[target];
    }
}