// Total Accepted: 3091
// Total Submissions: 11365
// Difficulty: Medium
// 17ms ?%

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 *      Example [123,[-456,[789]]]
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        //System.out.println(s);
        if (s.charAt(0) != '[')
            return new NestedInteger(Integer.valueOf(s));
        
        NestedInteger res = new NestedInteger();
        for (int i = 1, sgn = 1, num = 0; i < s.length() - 1; i++) {
            char ch = s.charAt(i);
            //System.out.println("i = " + i + " : " + ch);
            if (Character.isDigit(ch)) {
                num = num * 10 + (int)(ch - '0');
                if (!Character.isDigit(s.charAt(i + 1))) {
                    res.add(new NestedInteger(sgn * num));
                    num = 0;
                    sgn = 1;
                }
            } else
            if (ch == '-')
                sgn = -1;
            else
            if (ch == '[') {
                int tail = i + 1;
                for (int cnt = 1; cnt > 0; tail++)
                    if (s.charAt(tail) == '[') cnt++;
                    else
                    if (s.charAt(tail) == ']') cnt--;
                //System.out.println("tail = " + tail);
                res.add(deserialize(s.substring(i, tail + 1)));
                i = tail;
            }
        }
        return res;
    }
}