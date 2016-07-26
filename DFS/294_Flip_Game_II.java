// Total Accepted: 11366
// Total Submissions: 26820
// Difficulty: Medium
// 10ms 97%

public class Solution {
    public boolean canWin(String s) {
        HashMap<String, Boolean> h = new HashMap();
        return isWinner(s, h);
    }
    
    private boolean isWinner(String s, HashMap<String, Boolean> h) {
        if (h.containsKey(s))
            return h.get(s);
        
        boolean win = false;
        char[] c = s.toCharArray();
        for (int i = 1; !win && i < c.length; i++)
            if (c[i] == '+' && c[i - 1] == '+') {
                c[i] = '-'; c[i - 1] = '-';
                win = !isWinner(new String(c), h);
                c[i] = '+'; c[i - 1] = '+';
            }
        h.put(s, win);
        return win;
    }
}