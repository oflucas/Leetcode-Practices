// Total Accepted: 110387
// Total Submissions: 362014
// Difficulty: Easy
// 1ms 8%


public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m - 1; i >= 0; i--) nums1[i + n] = nums1[i];
        
        for (int k = 0, i = n, j = 0; i < m + n || j < n; k++)
            nums1[k] = (i == m + n || (j != n &&nums2[j] < nums1[i])) ? nums2[j++] : nums1[i++];
    }
}