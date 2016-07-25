// Total Accepted: 2490
// Total Submissions: 8447
// Difficulty: Hard
// 148ms 99.2%

public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length, ans = Integer.MIN_VALUE;
        int[] sum = new int[n];

        for (int l = 0; l < m; l++) {
        	Arrays.fill(sum, 0);
        	for(int r = l; r < m; r++) {
        		TreeSet<Integer> set = new TreeSet(Collections.singleton(0));
        		for (int i = 0, cum = 0; i < n; i++) {
        			sum[i] += matrix[i][r];
        			cum += sum[i];
        			Integer res = set.ceiling(cum - k);
        			if (res != null)
        				ans = Math.max(ans, cum - res);
        			set.add(cum);
        		}
        	}
        }

        return ans;
    }
}