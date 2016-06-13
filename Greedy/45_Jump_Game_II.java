//4ms 11% Total Accepted: 65804 Total Submissions: 258681 Difficulty: Hard
public class Solution {
    public int jump(int[] nums) {
        int step = 0, l = nums.length;
        for (int nextMax = 0, curMax = 0, i = 0; i < l && curMax < l - 1; i++) {
            nextMax = Math.max(nums[i] + i, nextMax);
            if (i == curMax) {
                step++;
                curMax = nextMax;
            }
        }
        return step;
    }
}
