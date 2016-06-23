// 0ms 100% Total Accepted: 75463 Total Submissions: 215037 Difficulty: Easy
public class Solution {
    // robbed[i] = nums[i] + passed[i - 1];
    // passed[i] = max{robbed[i - 1], passed[i - 1]}
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 1) return 0;
        int[] robbed = new int[n], passed = new int[n];
        robbed[0] = nums[0];
        passed[0] = 0;
        
        for (int i = 1; i < n; robbed[i] = nums[i] + passed[i - 1], i++)
            passed[i] = Math.max(robbed[i - 1], passed[i - 1]);
        
        return Math.max(robbed[n - 1], passed[n - 1]);
    }
}
