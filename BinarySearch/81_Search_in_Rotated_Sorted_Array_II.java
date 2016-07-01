// 81_Search_in_Rotated_Sorted_Array_II.java
// 1ms 100% Total Accepted: 66146 Total Submissions: 205555 Difficulty: Medium
public class Solution {
    public boolean search(int[] nums, int target) {
        for (int l = 0, r = nums.length - 1; l <= r; ) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) return true;
            if (nums[l] != nums[mid] || nums[r] != nums[mid]) {
                if (nums[l] < nums[mid] || nums[mid] > nums[r]) {
                    if (nums[l] <= target && target < nums[mid]) r = mid - 1; else l = mid + 1;
                } else {
                    if (nums[mid] < target && target <= nums[r]) l = mid + 1; else r = mid - 1;
                }
            } else {
                l++; r--;
            }
        }
        return false;
    }
}
