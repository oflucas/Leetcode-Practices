// Total Accepted: 73337
// Total Submissions: 248784
// Difficulty: Easy
// 3ms 50%

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++, n >>= 1) {
            ans <<= 1;
            ans |= n & 1;
        }
        return ans;
    }
}