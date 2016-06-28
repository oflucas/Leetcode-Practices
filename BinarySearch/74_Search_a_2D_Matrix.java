// 74_Search_a_2D_Matrix.java
// 1ms 90% Total Accepted: 83955 Total Submissions: 244749 Difficulty: Medium
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length, i = 0, j = n * m - 1;
        while (i < j) {
            int idmid = (i + j) / 2, vmid = matrix[idmid / m][idmid % m];
            if (target == vmid) return true;
            if (target > vmid)
                i = idmid + 1;
            else
                j = idmid - 1;
        }
        return matrix[i / m][i % m] == target;
    }
}
