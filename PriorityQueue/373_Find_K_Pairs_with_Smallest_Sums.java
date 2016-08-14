// Total Accepted: 7740
// Total Submissions: 28870
// Difficulty: Medium
// 7ms 97%

public class Solution {
    private class Pair implements Comparable<Pair>{
        int[] a1, a2;
        int i1, i2;
        
        public Pair(int j1, int j2, int[] arr1, int[] arr2) {
            a1 = arr1;
            a2 = arr2;
            i1 = j1;
            i2 = j2;
        }
        
        public int sum() {
            return a1[i1] + a2[i2];
        }
        
        public int compareTo(Pair p) {
            return this.sum() - p.sum();
        }
    }
    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = Math.min(nums1.length, k), n2 = nums2.length, sum = 0;
        List<int[]> ans = new ArrayList();
        if (n1 * n2 == 0) return ans;
        PriorityQueue<Pair> pq = new PriorityQueue();
        for (int i = 0; i < n1; pq.offer(new Pair(i++, 0, nums1, nums2)));
        
        for (int t = 0; t < k && !pq.isEmpty(); t++) {
            Pair p = pq.poll();
            ans.add(new int[]{nums1[p.i1], nums2[p.i2]});
            if (++p.i2 < n2)
                pq.offer(p);
        }
        return ans;
    }
}