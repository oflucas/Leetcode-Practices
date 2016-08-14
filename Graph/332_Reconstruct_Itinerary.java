// Total Accepted: 15972
// Total Submissions: 61003
// Difficulty: Medium
// 22ms 33%

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        HashMap<String, PriorityQueue<String>> h = new HashMap();
        for (String[] t : tickets) {
            PriorityQueue<String> pq = h.containsKey(t[0]) ? h.get(t[0]) : new PriorityQueue();
            pq.offer(t[1]);
            h.put(t[0], pq);
        }
        
        List<String> ans = new LinkedList();
        Stack<String> st = new Stack();
        st.push("JFK");
        while (!st.empty()) {
            String s = st.peek();
            if (!h.containsKey(s) || h.get(s).isEmpty()) {
                ans.add(0, s);
                st.pop();
            } else {
                st.push(h.get(s).poll());   
            }
        }
        return ans;
    }
}