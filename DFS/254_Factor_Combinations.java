// 254_Factor_Combinations.java
// 4ms 80% Total Accepted: 9513 Total Submissions: 26615 Difficulty: Medium
public class Solution {
    public List<List<Integer>> getFactors(int n) {
        return gf(2, n);
    }
    
    private List<List<Integer>> gf(int limit, int n) {
        List<List<Integer>> res = new ArrayList();
        for (int i = limit; i * i <= n; i++)
            if (n % i == 0) {
                res.add(Arrays.asList(i, n / i));
                List<List<Integer>> l = gf(i, n / i);
                for (List<Integer> li : l) {
                    List<Integer> tmp = new LinkedList(li);
                    tmp.add(0, i);
                    res.add(tmp);
                }
            }
        return res;
    }
}
