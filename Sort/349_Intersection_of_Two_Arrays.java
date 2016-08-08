// Total Accepted: 35556
// Total Submissions: 80014
// Difficulty: Easy
// 6ms 86%

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> a = new ArrayList();
        for (int i = 0, j = 0, n1 = nums1.length, n2 = nums2.length; i < n1 && j < n2; )
            if (nums1[i] < nums2[j]) 
                i++;
            else
            if (nums1[i] > nums2[j])
                j++;
            else {
                int t = nums1[i];
                a.add(t);
                for (; i < n1 && nums1[i] == t; i++);
                for (; j < n2 && nums2[j] == t; j++);
            }
        
        int[] ans = new int[a.size()];
        for (int i = 0; i < a.size(); i++) ans[i] = a.get(i);
        return ans;
    }
}