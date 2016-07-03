// 16_3Sum _Closest.java
// 15ms 50% Total Accepted: 83191 Total Submissions: 281525 Difficulty: Medium
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length, ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n - 2; i++) {
            int targ = target - nums[i];
            for (int l = i + 1, r = n - 1; l < r; ) {
                int sum = nums[l] + nums[r];
                if (Math.abs(targ - sum) < Math.abs(target - ans)) {
                    if (targ - sum == 0) return target;
                    ans = nums[i] + nums[l] + nums[r];
                }
                if (sum < targ) l++; else r--;    
            }
        }
        return ans;
    }
}
