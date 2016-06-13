//20ms 70% Total Accepted: 7096 Total Submissions: 33119 Difficulty: Hard
public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int l1 = nums1.length, l2 = nums2.length;
        int[] ans = new int[k];
        for (int k1 = Math.max(k - l2, 0); k1 <= Math.min(l1, k); k1++) {
            int[] t = maxMerg(maxChop(nums1, k1), maxChop(nums2, k - k1));
            if (larger(t, ans)) ans = t;
        }
        return ans;
    }
    
    private int[] maxChop(int[] a, int k) {
        int[] res = new int[k];
        for (int i = 0, len = a.length, j = 0; i < len; i++) {
            while (j > 0 && k - j < len - i && res[j - 1] < a[i]) j--;
            if (j < k)
                res[j++] = a[i];
        }
        return res;
    }
    
    private int[] maxMerg(int[] a, int[] b) {
        int la = a.length, lb = b.length, l = la + lb;
        int[] res = new int[l];
        for (int k = 0, i = 0, j = 0; k < l; k++)
            res[k] = j >= lb || (i < la && cmp(i, j, a, b)) ? a[i++] : b[j++];
        return res;
    }
    
    private boolean cmp(int i, int j, int[] a, int[] b) { // true if a > b
        for (; i < a.length && j < b.length; i++, j++)
            if (a[i] != b[j]) return a[i] > b[j];
        return i < a.length;
    }
    
    private boolean larger(int[] a, int[] b) { // whether a > b and lenA = lenB
        for (int i = 0; i < a.length; i++)
            if (a[i] != b[i]) return a[i] > b[i];
        return false;
    }
}
