// Total Accepted: 40127
// Total Submissions: 156221
// Difficulty: Easy
// 3ms 97%

public class NumArray {
    int[] sum;

    public NumArray(int[] nums) {
        int n = nums.length;
        sum = new int[n + 1];
        for (int i = 0; i < n; i++)
            sum[i + 1] = sum[i] + nums[i];
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);