// 136_Single_Number.java
// 1ms 100% Total Accepted: 136092 Total Submissions: 268753 Difficulty: Medium

public class Solution {
    public int singleNumber(int[] nums) {
        int x = 0;
        for (int i : nums) x ^= i;
        return x;
    }
}
