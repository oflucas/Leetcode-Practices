// Total Accepted: 5343
// Total Submissions: 17400
// Difficulty: Medium
// 30ms 95%

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new LinkedList();
        Arrays.sort(nums);
        int n = nums.length, best = 0;
        if (n < 1) return ans;
        
        int[] opt = new int[n], prev = new int[n];
        for (int i = 0; i < n; i++) {
            int max = 0;
            prev[i] = -1;
            for (int j = 0; j < i && nums[j] * 2 <= nums[i]; j++)
                if (nums[i] % nums[j] == 0 && opt[j] > max) {
                    max = opt[j];
                    prev[i] = j;
                }
            opt[i] = max + 1;
            
            if (opt[i] > opt[best]) best = i;
        }
        
        for (int i = best; i >= 0; i = prev[i])
            ans.add(nums[i]);
        return ans;
    }
}