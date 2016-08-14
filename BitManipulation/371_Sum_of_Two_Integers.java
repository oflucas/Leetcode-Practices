// Total Accepted: 24150
// Total Submissions: 46512
// Difficulty: Easy
// 0ms 100%


public class Solution {
    public int getSum(int a, int b) {
        for (; b != 0; b <<= 1) {
            int tmp = a ^ b;
            b = a & b;
            a = tmp;
        }
        return a;
    }
}