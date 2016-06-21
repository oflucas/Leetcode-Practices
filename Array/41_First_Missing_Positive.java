// 1ms 100% Total Accepted: 67068 Total Submissions: 278653 Difficulty: Hard
public class Solution {
    public int firstMissingPositive(int[] nums) {
        // we want to arrange nums as 1,2,x,4,5. where x is something larger than n.
        int n = nums.length, k = 1;
        for (int i = 0; i < n; i++)
            // for nums[i] > n or <= 0, simply pass
            // while nums[i] - 1 != i, swap until nums[i] == i + 1. But need to
            // consider the element you're goint to swap is eq. to nums[i], i.e.,
            // nums[i] == nums[nums[i] - 1]. THe two conditions can be combined.
            while (nums[i] <= n && nums[i] > 0 && nums[nums[i] - 1] != nums[i])
                swap(i, nums[i] - 1, nums);
        for (int i = 0; i < n && nums[i] == k; i++, k++);
        return k;
    }
    
    private void swap(int i, int j, int[] nums) {
        int t = nums[i]; nums[i] = nums[j]; nums[j] = t;
    }
}
