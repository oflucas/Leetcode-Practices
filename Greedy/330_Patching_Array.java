// 1ms 100% Total Accepted: 11539 Total Submissions: 38544 Difficulty: Hard
public class Solution {
    // say nums = []
    // add 1 to reach [1, 2)
    // add 2 to reach [1, 2+2)
    // add 4 to reach [1, 4+4)
    // add 8 to reach [1, 8+8)
    // .. each time you need to add the sum cuz you can't reach it
    public int minPatches(int[] nums, int n) {
        int reach = 1, add = 0;
        for (int num : nums) {
            for (; num > reach && n >= reach && reach > 0; reach += reach, add++);
            reach += num;    
        }
        for (; n >= reach && reach > 0; reach += reach, add++); // n >= reach is very important
        return add;
    }
}
