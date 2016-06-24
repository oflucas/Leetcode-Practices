//209_Minimum_Size_Subarray_Sum.java
//2ms 10% Total Accepted: 42612 Total Submissions: 155712 Difficulty: Medium
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length, ans = n + 1;
        for (int i = 0, j = 0, sum = 0; i < n; i++) {
            sum += nums[i];
            for (; sum >= s && j <= i; sum -= nums[j++])
                ans = Math.min(ans, i - j + 1);
        }
        return ans > n ? 0 : ans;
    }
}
