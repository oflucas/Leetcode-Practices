// 341_Flatten_Nested_List_Iterator.java
// 8ms 80% Total Accepted: 8946 Total Submissions: 29405 Difficulty: Medium
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
public class NestedIterator implements Iterator<Integer> {
    Stack<Iterator<NestedInteger>> st;
    Integer nextV;

    public NestedIterator(List<NestedInteger> nestedList) {
        st = new Stack();
        if (nestedList != null)
            st.push(nestedList.iterator());
        nextV = null;
    }

    @Override
    public Integer next() {
        return nextV;
    }

    @Override
    public boolean hasNext() {
        nextV = null;
        while (!st.empty()) {
            Iterator<NestedInteger> cur = st.peek();
            if (cur.hasNext()) {
                NestedInteger y = cur.next();
                if (y.isInteger()) {
                    nextV = y.getInteger();
                    return true;
                } else   
                    st.push(y.getList().iterator());    // is a list
            } else       
                st.pop();   // current stack level does not have Integer anymore
        }
        return false;
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
