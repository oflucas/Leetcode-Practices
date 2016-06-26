// 64_Minimum_Path_Sum.java
// 5ms 60% Total Accepted: 75035 Total Submissions: 211699 Difficulty: Medium
public class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for (int i = n - 1; i >= 0; i--)
            for (int j = m - 1; j >= 0; j--)
                if (i < n - 1 && j < m - 1)
                    grid[i][j] += Math.min(grid[i + 1][j], grid[i][j + 1]);
                else
                if (!(i == n - 1 && j == m - 1))
                    grid[i][j] += i < n - 1 ? grid[i + 1][j] : grid[i][j + 1];
        
        return grid[0][0];
    }
}
