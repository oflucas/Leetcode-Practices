// Total Accepted: 6375
// Total Submissions: 23199
// Difficulty: Easy
// 11ms 11%

public class Solution {
    public int integerReplacement(long n) {
        if (n <= 1) return (int)(1 - n);
        return 1 + ((n & 1) > 0 ? 
            Math.min(integerReplacement(n - 1), integerReplacement(n + 1)) : integerReplacement(n >> 1));
    }
}