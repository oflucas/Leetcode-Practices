// Total Accepted: 89257
// Total Submissions: 395670
// Difficulty: Hard
// 5ms 90%

public class Solution {
    public boolean isMatch(String str, String pat) {
        char[] s = str.toCharArray(), p = pat.toCharArray();
        int n = s.length, m = p.length;
        boolean[][] f = new boolean[m + 1][n + 1];
        
        f[0][0] = true;
        for (int i = 1; i <= m; i++)
            for (int j = 0; j <= n; j++) {
                if (p[i - 1] == '*') {
                    char x = p[i - 2];
                    f[i][j] = f[i - 2][j] || (j > 0 && (x == s[j - 1] || x == '.') && f[i][j - 1]);
                } else 
                if (j > 0)
                    f[i][j] = ((s[j - 1] == p[i - 1] || p[i - 1] == '.') && f[i - 1][j - 1]);
            }
                
        return f[m][n];
    }
}