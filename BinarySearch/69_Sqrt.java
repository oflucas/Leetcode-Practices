// 4ms 10% Total Accepted: 98609 Total Submissions: 384385 Difficulty: Medium

public class Solution {
    public int mySqrt(int x) {
        long l = 0, r = x;
        while (l < r) {
            long mid = (l + r + 1) / 2;
            if (mid * mid == x) return (int) mid;
            else
            if (mid * mid > x)
                r = mid - 1;
            else
                l = mid;
        }
        return (int) l;
    }
}
