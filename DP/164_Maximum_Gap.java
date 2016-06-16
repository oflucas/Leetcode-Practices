// 5ms 70% Total Accepted: 33150 Total Submissions: 122293 Difficulty: Hard
public class Solution {
    // bucket sort with bucket size (max - min) / (n - 1), max gap points must lie in diff buckets
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        int min = nums[0], max = nums[0];
        for (int y : nums) {
            min = Math.min(min, y);
            max = Math.max(max, y);
        }
        int sizeb = (max - min) / (n - 1);
        if (max - min == 0) return 0;
        int[] bmin = new int[n], bmax = new int[n];
        Arrays.fill(bmin, -1); Arrays.fill(bmax, -1);
        for (int y : nums) {
            long keyy = (long)(y - min) * (n - 1) / (max - min); // (y - min) / sizeb;
            int key = (int) keyy;
            if (bmin[key] < 0) {
                bmin[key] = y;
                bmax[key] = y;
            } else {
                bmin[key] = Math.min(bmin[key], y);
                bmax[key] = Math.max(bmax[key], y);
            }
        }
        
        int maxGap = 0;
        for (int prev = min, j = 0; j < n; j++)
            if (bmin[j] > 0) {
                maxGap = Math.max(maxGap, bmin[j] - prev);
                prev = bmax[j];
            }
        
        return maxGap;
    }
}
