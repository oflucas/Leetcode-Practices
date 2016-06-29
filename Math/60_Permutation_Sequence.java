// 60_Permutation_Sequence.java
// 2ms 94% Total Accepted: 57778 Total Submissions: 224996 Difficulty: Medium
public class Solution {
    public String getPermutation(int n, int k) {
        int[] f = new int[n];
        boolean[] written = new boolean[n + 1];
        f[0] = 1;
        for (int i = 1; i < n; i++) f[i] = i * f[i - 1];
        StringBuilder sb = new StringBuilder();
        
        for (int i = n; i > 0 && k > 0; i--) {
            int r = (k - 1) / f[i - 1], j = 1;
            for (int t = -1; t < r; j++)
                if (!written[j]) t++;
            written[--j] = true;
            sb.append(j);
            //System.out.println(r + ", " + j);
            k -= r * f[i - 1];
        }
        
        for (int i = 1; k > 0 && i <= n; i++)
            if (!written[i]) sb.append(i);
            
        return sb.toString();
    }
}
