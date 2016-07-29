// Total Accepted: 46089
// Total Submissions: 191226
// Difficulty: Hard
// 13ms 80%

public class Solution {
    // h[j] = height of 1 of column j of current row
    // l[j] = leftmost column with height at least > h[j] of current row
    // r[j] = rightmost column with height at least > h[j] of current row
    // area of rectangle j = h[j] * (r[j] - l[j] + 1);
    public int maximalRectangle(char[][] mat) {
        if (mat == null || mat.length < 1) 
            return 0;
            
        int n = mat.length, m = mat[0].length, ans = 0;
        int[] h = new int[m], r = new int[m], l = new int[m];
        for (int j = 0; j < m; j++) {
            l[j] = 0;
            r[j] = m - 1;
            h[j] = 0;
        }
        
        for (int i = 0; i < n; i++) {
            int maxleft = 0, minright = m - 1;
            for (int j = 0; j < m; j++)
                if (mat[i][j] == '1') {
                    h[j]++;
                    l[j] = Math.max(l[j], maxleft);
                } else {
                    h[j] = 0;
                    l[j] = 0;
                    maxleft = j + 1;
                }
            
            for (int j = m - 1; j >= 0; j--)
                if (mat[i][j] == '1')
                    r[j] = Math.min(r[j], minright);
                else {
                    r[j] = m - 1;
                    minright = j - 1;
                }
                
            for (int j = 0; j < m; j++)
                ans = Math.max(ans, h[j] * (r[j] - l[j] + 1));
        }
        
        return ans;
    }
}