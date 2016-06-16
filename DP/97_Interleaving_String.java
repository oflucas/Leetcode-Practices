// 10ms 36% Total Accepted: 51075 Total Submissions: 224301 Difficulty: Hard
public class Solution {
    // f[la][lb] defines whether s3[0 ~ la + lb - 1] is interleave of s1[0 ~ la - 1] and s2[0 ~ lb - 1]
    public boolean isInterleave(String s1, String s2, String s3) {
        char[] a = s1.toCharArray(), b = s2.toCharArray(), c = s3.toCharArray();
        int n = a.length, m = b.length, w = c.length; 
        if (w != n + m) return false;
        boolean[][] f = new boolean[n + 1][m + 1];
        f[0][0] = true;
        
        for (int l = 0; l < w; l++)
            for (int la = Math.max(0, l - m); la <= Math.min(l, n); la++) {
                int lb = l - la;
                if (la < n)
                    f[la + 1][lb] |= a[la] == c[l] && f[la][lb];
                if (lb < m)
                    f[la][lb + 1] |= b[lb] == c[l] && f[la][lb];
            }
        return f[n][m];
    }
}
