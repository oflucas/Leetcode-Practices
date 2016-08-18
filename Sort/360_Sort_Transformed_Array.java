// Total Accepted: 2608
// Total Submissions: 6402
// Difficulty: Medium
// 2ms 75%

public class Solution {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        double piv = -b / 2.0 / a;
        int n = nums.length;
        boolean direction = a < 0 || (a == 0 && b > 0);
        int[] ans = new int[n];
        for (int k = 0, i = 0, j = n - 1; k < n; k++)
            ans[direction ? k : n - k - 1] = cal(nums[(Math.abs(nums[j] - piv) > Math.abs(nums[i] - piv) ? j-- : i++)], a, b, c);
        return ans;
    }
    
    private int cal(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}