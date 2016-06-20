//7ms 95% Total Accepted: 12802 Total Submissions: 71489 Difficulty: Medium
public class NumArray {
    int[] bit, a;
    int n;
    
    public NumArray(int[] nums) {
          n = nums.length;
          a = new int[n + 1];
          bit = new int[n + 1];
          for (int i = 0; i < n; i++) update(i, nums[i]);
    }

    void update(int i, int val) {
        int diff = val - a[i];
        a[i] = val;
        for(i++; i <= n; i += i & -i) bit[i] += diff;
    }

    public int sumRange(int i, int j) {
        return sum(j) - sum(i - 1);
    }
    
    private int sum(int i) {
        int res = 0;
        for (i++; i > 0; i -= i & -i) res += bit[i];
        return res;
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);
