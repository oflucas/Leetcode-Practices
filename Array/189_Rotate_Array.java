// Total Accepted: 84504
// Total Submissions: 380522
// Difficulty: Easy
// 1ms 97%

public class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length, m = gcd(k, n);
        for (int t = 0; t < m; t++) {
            int i = t, next = Integer.MIN_VALUE;
            do {
                int tmp = nums[i];
                nums[i] = next;
                next = tmp;
                i = (i + k) % n;
            } while (next != Integer.MIN_VALUE);
        }
    }
    
    public int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a % b);
    }

    // 2nd method
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}