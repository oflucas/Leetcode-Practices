//293_Flip_Game.java
//1ms 90% Total Accepted: 10168 Total Submissions: 20128 Difficulty: Easy
public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        char[] c = s.toCharArray();
        List<String> ans = new ArrayList();
        for (int i = 1; i < c.length; i++)
            if (c[i - 1] == '+' && c[i] == '+') {
                c[i - 1] = '-'; c[i] = '-';
                ans.add(new String(c));
                c[i - 1] = '+'; c[i] = '+';
            }
        return ans;
    }
}
