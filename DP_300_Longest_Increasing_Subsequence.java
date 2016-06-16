// 3ms 69% Total Accepted: 32069 Total Submissions: 92080 Difficulty: Medium
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int[] lis = new int[nums.length];
        int n = 0;
        for (int i : nums) {
            int j = Arrays.binarySearch(lis, 0, n, i);
            if (j < 0) j = -j - 1;
            lis[j] = i;
            if (j == n) n++;
        }
        return n;   
    }
}
