// Total Accepted: 114700
// Total Submissions: 370456
// Difficulty: Hard
// 1ms 100%

public class Solution {
    public int search(int[] nums, int target) {
        for (int i = 0, j = nums.length - 1; i <= j; ) {
            int mid = (i + j) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < nums[j]) {
                if (target > nums[mid] && target <= nums[j]) 
                    i = mid + 1;
                else
                    j = mid - 1;
            } else {
                if (target < nums[mid] && target >= nums[i])
                    j = mid - 1;
                else
                    i = mid + 1;
            }
        }
        return -1;
    }
}