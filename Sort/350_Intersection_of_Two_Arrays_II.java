// Total Accepted: 25174
// Total Submissions: 60227
// Difficulty: Easy
// 6ms 75%


public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        ArrayList<Integer> a = new ArrayList();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0, j = 0, n1 = nums1.length, n2 = nums2.length; i < n1 && j < n2; ) {
            if (nums1[i] < nums2[j]) i++;
            else 
            if (nums1[i] > nums2[j]) j++;
            else {
                int t = nums1[i];
                for (; i < n1 && j < n2 && nums1[i] == t && nums2[j] == t; i++, j++) a.add(t);
                for (; i < n1 && nums1[i] == t; i++);
                for (; j < n2 && nums2[j] == t; j++);
            }
        }
        
        int[] ans = new int[a.size()];
        int k = 0;
        for (int num : a) ans[k++] = num;
        return ans;
    }
}