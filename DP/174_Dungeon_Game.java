//174_Dungeon_Game.java
//6ms 20% Total Accepted: 25660 Total Submissions: 120368 Difficulty: Hard
public class Solution {
    public int calculateMinimumHP(int[][] g) {
        int n = g.length, m = g[0].length;
        for (int i = n - 1; i >= 0; i--)
            for (int j = m - 1; j >= 0; j--) {
                if (j == m - 1 && i == n - 1)
                    g[i][j] = Math.min(0, g[i][j]);
                else if (j == m - 1)
                    g[i][j] = Math.min(0, g[i][j] + g[i + 1][j]);
                else if (i == n - 1)
                    g[i][j] = Math.min(0, g[i][j] + g[i][j + 1]);
                else
                    g[i][j] = Math.min(0, g[i][j] + Math.max(g[i + 1][j], g[i][j + 1]));
            }
        return -g[0][0] + 1;
    }
}
