// Total Accepted: 195390
// Total Submissions: 840214
// Difficulty: Medium
// 45ms 52% 

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] c = s.toCharArray();
        int[] cnt = new int[128];
        int ans = 0;
        for (int i = 0, j = 0; j < c.length; j++) {
            if (++cnt[c[j]] > 1) {
                for (; cnt[c[i]] < 2; cnt[c[i++]]--);
                cnt[c[i++]]--;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }
}