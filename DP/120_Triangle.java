//120_Triangle.java
// 4ms 93% Total Accepted: 73273 Total Submissions: 238771 Difficulty: Medium
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] f = new int[n];
        for (int i = 0; i < n; i++)
            f[i] = triangle.get(n - 1).get(i);
        
        for (int k = n - 2; k >= 0; k--)
            for (int i = 0; i <= k; i++)
                f[i] = triangle.get(k).get(i) + Math.min(f[i], f[i + 1]);
        
        return f[0];
    }
}
