// Total Accepted: 96416
// Total Submissions: 258610
// Difficulty: Medium
// 1ms 85%

public class Solution {
    public int uniquePaths(int m, int n) {
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for (int i = m - 2; i >= 0; i--)
            for (int j = n - 2; j >= 0; j--)
                f[j] = f[j] + f[j + 1];
        return f[0];
    }
}