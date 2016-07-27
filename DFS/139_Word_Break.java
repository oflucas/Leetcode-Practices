// Total Accepted: 94978
// Total Submissions: 363145
// Difficulty: Medium
// 12ms 65%

public class Solution {
    private HashMap<String, Boolean> h = new HashMap();
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (h.containsKey(s)) return h.get(s);
        
        boolean canBreak = false;
        if (wordDict.contains(s)) canBreak = true;
        for (int i = 1; !canBreak && i < s.length(); i++)
            canBreak = (wordDict.contains(s.substring(0, i)) && wordBreak(s.substring(i), wordDict));
        
        h.put(s, canBreak);
        return canBreak;
    }
}