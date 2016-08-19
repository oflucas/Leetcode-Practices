// Total Accepted: 106514
// Total Submissions: 324068
// Difficulty: Medium
// 4ms 99%

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> cur = new ArrayList();
        dfs(target, 0, candidates, ans, cur);
        return ans;
    }
    
    private void dfs(int targ, int bd, int[] cand, List<List<Integer>> ans, List<Integer> cur) {
        if (targ == 0) {
            ans.add(new ArrayList(cur));
            return;
        }
        
        for (int i : cand)
            if (i >= bd && (i == targ || targ - i >= bd)) {
                cur.add(i);
                dfs(targ - i, i, cand, ans, cur);
                cur.remove(cur.size() - 1);
            }
    }
}