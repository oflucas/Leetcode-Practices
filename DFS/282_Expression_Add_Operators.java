// Total Accepted: 15701
// Total Submissions: 58967
// Difficulty: Hard
// 207ms 76%

public class Solution {
    public List<String> addOperators(String num, int target) {
        char[] nums = num.toCharArray();
        List<String> ans = new ArrayList();
        List<Long> val = new ArrayList();
        List<Character> op = new ArrayList();
        find(0, 0, 1, nums, val, op, ans, target);
        return ans;
    }
    
    public void find(int idx, long toAdd, long toMult,char[] nums, List<Long> val, List<Character> op, List<String> ans, int target) {
        if (idx == nums.length) return;
        
        long n = 0;
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && n == 0) return;
            n = n * 10 + (int)(nums[i] - '0');
            for (char opr : oprs) {
                val.add(n);
                op.add(opr);
                if (opr == '+') find(i + 1, toAdd + n * toMult, 1, nums, val, op, ans, target);
                else
                if (opr == '-') find(i + 1, toAdd + n * toMult, -1, nums, val, op, ans, target);
                else
                if (opr == '*') find(i + 1, toAdd, n * toMult, nums, val, op, ans, target);
                val.remove(val.size() - 1);
                op.remove(op.size() - 1);
            }
        }
        
        if (toAdd + n * toMult == target) { // found solution and output
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < val.size(); j++)
                sb.append(val.get(j)).append(op.get(j));
            sb.append(n);
            ans.add(sb.toString());
        }
    }
    
    public final static char[] oprs = {'+', '-', '*'};
}