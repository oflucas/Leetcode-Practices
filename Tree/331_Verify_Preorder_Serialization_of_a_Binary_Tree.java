// Total Accepted: 16914
// Total Submissions: 51674
// Difficulty: Medium
// 22ms 20%

public class Solution {
    public boolean isValidSerialization(String preorder) {
        Stack<String> st = new Stack();
        String[] a = preorder.split(",");
        int i = 0, n = a.length;
        
        while (i < n) {
            if (a[i].equals("#")) {
                while (!st.empty() && st.peek().equals("#")) {
                    st.pop();
                    if (st.empty()) return false;
                    st.pop();
                }
            }
            st.push(a[i++]);
        }
        
        return st.pop().equals("#") && st.empty();
    }
}