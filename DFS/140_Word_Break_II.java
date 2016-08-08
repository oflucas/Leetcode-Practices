// Total Accepted: 62266
// Total Submissions: 301478
// Difficulty: Hard
// 21ms 14%

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        HashMap<String, List<String>> h = new HashMap();
        wb(s, wordDict, h);
        return h.get(s);
    }
    
    private boolean wb(String s, Set<String> dict, HashMap<String, List<String>> h) {
        if (h.containsKey(s))
            return !h.get(s).isEmpty();
        
        List<String> l = new ArrayList();
        if (dict.contains(s)) l.add(s);
        for (int w = 1; w < s.length(); w++) {
            String cand = s.substring(0, w), tail = s.substring(w);
            if (dict.contains(cand) && wb(tail, dict, h))
                for (String i : h.get(tail)) l.add(cand + " " + i);
        }
        
        h.put(s, l);
        return !l.isEmpty();
    }
}