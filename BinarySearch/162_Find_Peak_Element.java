//0ms 100% Total Accepted: 69322 Total Submissions: 208433 Difficulty: Medium
public class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length, l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] < nums[mid + 1])
                l = mid + 1;
            else
            if (mid > 0 && nums[mid] < nums[mid - 1])
                r = mid;
            else
                return mid;
        }
        return l;
    }
}
