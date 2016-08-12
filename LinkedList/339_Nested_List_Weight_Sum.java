// Total Accepted: 6113
// Total Submissions: 10578
// Difficulty: Easy
// 2ms 99%

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return dSum(nestedList, 1);
    }
    
    private int dSum(List<NestedInteger> l, int d) {
        int sum = 0;
        for (NestedInteger i : l)
            if (i.isInteger())
                sum += d * i.getInteger();
            else
                sum += dSum(i.getList(), d + 1);
        return sum;
    }
}