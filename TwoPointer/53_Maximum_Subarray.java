//53_Maximum_Subarray.java
//2ms 70% Total Accepted: 118521 Total Submissions: 319859 Difficulty: Medium
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length < 1) return 0;
        int max = Integer.MIN_VALUE, n = nums.length;
        for (int i = 0, j = 0, sum = 0; j < n; j++) {
            sum += nums[j];
            max = Math.max(max, sum);
            for (; sum < 0 && i <= j; sum -= nums[i++]);
        }
        return max;
    }
}
