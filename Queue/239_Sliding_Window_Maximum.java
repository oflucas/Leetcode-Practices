// Total Accepted: 32785
// Total Submissions: 112884
// Difficulty: Hard
// 27ms 80%

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<int[]> q = new LinkedList();
        int n = nums.length;
        int[] ans = new int[k == 0 ? 0 : n - k + 1];
        
        for (int i = 0; i < n; i++) {
            for (; !q.isEmpty() && q.peekLast()[0] <= nums[i]; q.pollLast());
            q.offerLast(new int[]{nums[i], i});
            for (; q.peekFirst()[1] <= i - k; q.pollFirst());
            if (i >= k - 1)
                ans[i - k + 1] = q.peekFirst()[0];
        }
        
        return ans;
    }
}