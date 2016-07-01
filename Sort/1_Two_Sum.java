// 1_Two_Sum.java
// 9ms 50% Total Accepted: 251539 Total Submissions: 1025837 Difficulty: Easy
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[][] a = new int[n][2];
        for (int i = 0; i < n; a[i][0] = nums[i], a[i][1] = i, i++);
        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        for (int i = 0, j = nums.length - 1; i < j; i++) {
            for (; i < j && a[i][0] + a[j][0] > target; j--);
            if (i < j && a[i][0] + a[j][0] == target)
                return new int[]{a[i][1], a[j][1]};
        }
        
        return null;
    }
}
