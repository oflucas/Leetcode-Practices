// Total Accepted: 2059
// Total Submissions: 4152
// Difficulty: Medium
// 21ms 10%
// To improve, you can use bucket sort!

public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int k = updates.length;
        int[][] upd_arr = new int[k * 2][];
        for (int i = 0, j = 0; i < k; i++) {
            upd_arr[j++] = new int[] {updates[i][0], updates[i][2]};
            upd_arr[j++] = new int[] {updates[i][1] + 1, -updates[i][2]};
        }
        Arrays.sort(upd_arr, new Updates_cmp());
        
        int[] res = new int[length];
        for (int i = 0, j = 0, sum = 0; i < length; res[i++] = sum)
            for (; j < 2 * k && upd_arr[j][0] == i; sum += upd_arr[j++][1]);
        
        return res;
    }
    
    private class Updates_cmp implements Comparator<int[]> {
        @Override
            public int compare(int[] a, int [] b) {
                    return a[0] - b[0];
            }
    }
}