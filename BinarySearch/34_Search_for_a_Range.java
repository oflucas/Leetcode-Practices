// Total Accepted: 92837
// Total Submissions: 311542
// Difficulty: Medium
// 1ms 68%

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {search(nums, target, false), search(nums, target, true)};
    }
    
    public int search(int[] nums, int target, boolean upmost) {
        int i = 0, j = nums.length - 1;
        int c = upmost ? 1 : 0;
        while (i < j) {
            int mid = (i + j + c) / 2;
            if (target > nums[mid])
                i = mid + 1;
            else
            if (target < nums[mid])
                j = mid - 1;
            else
                if (upmost) i = mid; else j = mid;
        }
        if (i == nums.length || j < 0 || nums[i] != target)
            return -1;
        else
            return i;
    }
}