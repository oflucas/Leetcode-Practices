// Total Accepted: 51543
// Total Submissions: 202430
// Difficulty: Medium
// 1ms 92%

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new LinkedList();
        int n = nums.length, st = 0;
        if (n < 1) return ans;
        
        for (int i = 1; i < n; i++)
            if (nums[i] != nums[i - 1] + 1) {
                ans.add(anEntry(nums[st], nums[i - 1]));
                st = i;
            }
        ans.add(anEntry(nums[st], nums[n - 1]));
        return ans;
    }
    
    private String anEntry(int a, int b) {
        if (a == b)
            return String.valueOf(a);
        return String.valueOf(a) + "->" + String.valueOf(b);
    }
}