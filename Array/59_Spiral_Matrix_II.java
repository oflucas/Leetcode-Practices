// Total Accepted: 59420
// Total Submissions: 163874
// Difficulty: Medium
// 1ms 3%

public class Solution {
    private final static int[] dx = {1,0,-1,0};
    private final static int[] dy = {0,1,0,-1};
    public int[][] generateMatrix(int n) {
        int[][] g = new int[n][n];
        for (int i = 1, d = 0, n2 = n * n, y = 0, x = -1; i <= n2; i++) {
            int y1 = y + dy[d], x1 = x + dx[d];
            if (y1 == n || y1 < 0 || x1 == n || x1 < 0 || g[y1][x1] > 0) {
                d = (d + 1) % 4;
                y1 = y + dy[d]; x1 = x + dx[d];
            }
            x = x1; y = y1;
            g[y][x] = i;
        }
        return g;
    }
}