// Total Accepted: 63113
// Total Submissions: 215041
// Difficulty: Hard
// 15ms 50%

public class Solution {
    public int minDistance(String word1, String word2) {
        char[] a = word1.toCharArray(), b = word2.toCharArray();
        int n = a.length, m = b.length;
        int[][] minD = new int[n + 1][m + 1];
        for (int j = 0; j < m; j++)
            minD[0][j + 1] = j + 1;
        for (int i = 0; i < n; i++)
            minD[i + 1][0] = i + 1;
            
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                minD[i + 1][j + 1] = Math.min(minD[i + 1][j], minD[i][j + 1]) + 1;
                int t = minD[i][j] + (a[i] == b[j] ? 0 : 1);
                minD[i + 1][j + 1] = Math.min(minD[i + 1][j + 1], t);
            }
        
        return minD[n][m];
    }
}