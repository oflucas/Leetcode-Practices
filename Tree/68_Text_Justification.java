// Total Accepted: 37313
// Total Submissions: 222528
// Difficulty: Hard
// 13ms 1%

public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> ans = new ArrayList();
        for (int i = 0, j = 1, curL = 0, n = words.length; i < n; i = j++) {
            for (curL = words[i].length(); j < n && curL + 1 + words[j].length() <= L; curL += 1 + words[j++].length());
            if (j == n)
                ans.add(lastLine(i, j - 1, curL, L, words));
            else
                ans.add(line(i, j - 1, curL, L, words));
        }
        return ans;
    }
    
    private String spacePad(int n) {
        return n < 1 ? "" : String.format("%" + n + "s", " ");
    }
    
    private String line(int st, int ed, int curL, int L, String[] words) {
        if (st == ed)
            return words[st] + spacePad(L - curL);
            
        StringBuilder sb = new StringBuilder(words[st]);
        String pad = spacePad(1 + (L - curL) / (ed - st));
        for (int restSpace = (L - curL) % (ed - st), i = st + 1; i <= ed; i++, restSpace--) {
            if (restSpace > 0) sb.append(' ');
            sb.append(pad).append(words[i]); 
        }
        return sb.toString();
    }
    
    private String lastLine(int st, int ed, int curL, int L, String[] words) {
        StringBuilder sb = new StringBuilder(words[st]);
        for (int i = st + 1; i <= ed; sb.append(' ').append(words[i++]));
        sb.append(spacePad(L - curL));
        return sb.toString();
    }
}