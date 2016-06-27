//311_Sparse_Matrix_Multiplication.java
//64ms 90% Total Accepted: 7476 Total Submissions: 15665 Difficulty: Medium
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int n = A.length, m = B.length, mb = B[0].length;
        int[][] ans = new int[n][mb];
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (A[i][j] != 0) {
                    int a = A[i][j];
                    for (int k = 0; k < mb; k++)
                        if (B[j][k] != 0)
                            ans[i][k] += a * B[j][k];
                }
        
        return ans;
    }
} //64ms 90%
