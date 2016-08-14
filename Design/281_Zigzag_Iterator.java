// Total Accepted: 12341
// Total Submissions: 27406
// Difficulty: Medium
// 6ms 50%


public class ZigzagIterator {
    Deque<Iterator<Integer>> q;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList();
        if (v1 != null && v1.iterator().hasNext()) 
            q.offer(v1.iterator());
        if (v2 != null && v2.iterator().hasNext())
            q.offer(v2.iterator());
    }

    public int next() {
        Iterator<Integer> it = q.poll();
        int ans = it.next();
        if (it.hasNext()) q.offer(it);
        return ans;
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */