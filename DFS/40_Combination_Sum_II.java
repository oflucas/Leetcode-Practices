// 4ms 96% Total Accepted: 72025 Total Submissions: 256326 Difficulty: Medium
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> path = new ArrayList();
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(candidates);
        solve(0, target, candidates, path, res);
        return res;
    }
    
    private void solve(int pos, int trgt, int[] cand, List<Integer> path, List<List<Integer>> res) {
        if (trgt == 0) {
            res.add(new ArrayList(path));
            return;
        }
        
        for (int i = pos; i < cand.length && cand[i] <= trgt; i++)
            if (i == pos || cand[i] != cand[i - 1]) {
                path.add(cand[i]);
                solve(i + 1, trgt - cand[i], cand, path, res);
                path.remove(path.size() - 1);
            }
    }
}
