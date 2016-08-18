// Total Accepted: 79325
// Total Submissions: 439304
// Difficulty: Medium
// 1ms 92%

public class Solution {
    public int numDecodings(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        if ( n < 1) return 0;
        int[] f = new int[n + 1];
        f[0] = 1;
        if (ch[0] != '0') f[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (ch[i-1] != '0') f[i] = f[i - 1];
            if (ch[i-2] == '1' || (ch[i-2] == '2' && ch[i-1] <= '6')) f[i] += f[i - 2];
        }
        return f[n];
    }
}