// 47_Permutations_II.java
// 9ms 30% Total Accepted: 76035 Total Submissions: 265865 Difficulty: Medium
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> path = new LinkedList();
        List<List<Integer>> ans = new LinkedList();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(0, nums, used, path, ans);
        return ans;
    }
    
    private void dfs(int depth, int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> ans) {
        if (depth == nums.length) {
            ans.add(new LinkedList(path));
            return;
        }
        int prev = -1;
        for (int i = 0; i < nums.length; i++)
            if (!used[i] && (prev < 0 || nums[i] != nums[prev])) {
                prev = i;
                used[i] = true;
                path.add(nums[i]);
                dfs(depth + 1, nums, used, path, ans);
                path.remove(path.size() - 1);
                used[i] = false;
            }
    }
}
