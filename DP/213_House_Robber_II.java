// Total Accepted: 33510
// Total Submissions: 105962
// Difficulty: Medium
// 3ms 90%

public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n < 1) return 0;
        if (n == 1) return nums[0];
        return Math.max(simpleRob(0, n - 1, nums), simpleRob(1, n - 1, nums));
    }
    
    private int simpleRob(int st, int n, int[] a) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = a[st];
        for (int i = 2; i <= n; i++)
            f[i] = Math.max(f[i - 1], f[i - 2] + a[st - 1 + i]);
        return f[n];
    }
}