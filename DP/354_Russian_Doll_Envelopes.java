// Total Accepted: 5478
// Total Submissions: 18812
// Difficulty: Hard
// 550ms 30%

public class Solution {
    public int maxEnvelopes(int[][] envs) {
        Arrays.sort(envs, new Comparator<int[]>(){
           @Override
           public int compare(int[] a, int[] b) {
               return a[0] - b[0];
           }
        });
        
        int n = envs.length, ans = 0;
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++)
                if (envs[j][0] < envs[i][0] && envs[j][1] < envs[i][1])
                    f[i] = Math.max(f[i], f[j] + 1);
            ans = Math.max(ans, f[i]);
        }
        
        return ans;
    }
}