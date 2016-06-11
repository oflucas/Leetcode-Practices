//1ms 100% Total Accepted: 83158 Total Submissions: 284590 Difficulty: Medium
public class Solution {
    private char[][] c = {
        {'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},
        {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}
    };
    public List<String> letterCombinations(String digits) {
        int depth = 0, n = digits.length();
        char[] digit = digits.toCharArray(), p = new char[n];
        int[] st = new int[n + 1];
        List<String> res = new ArrayList();
        if (n < 1) return res;
        
        for (st[0] = -1; depth >= 0; ) {
            if (depth == n) {
                res.add(new String(p));
                depth--;
                continue;
            }
            
            if (++st[depth] == c[digit[depth] - '2'].length)
                depth--;
            else {
                p[depth] = c[digit[depth] - '2'][st[depth]];
                st[++depth] = -1;
            }
        }
        
        return res;
    }
}
