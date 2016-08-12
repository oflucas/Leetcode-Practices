// Total Accepted: 84842
// Total Submissions: 430870
// Difficulty: Medium
// 26ms 95%

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord.equals(endWord)) return 0;
        HashMap<String, String>[] h = new HashMap[2];
        for (int dir = 0; dir <= 1; h[dir++] = new HashMap());
        String res = dfs(Collections.singleton(beginWord), Collections.singleton(endWord), wordList, true, h);
        if (res == null) return 0;
        int ans = 1;
        for (String i = res; !i.equals(beginWord); i = h[1].get(i)) ans++;
        for (String i = res; !i.equals(endWord); i = h[0].get(i)) ans++;
        return ans;
    }
    
    private String dfs(Set<String> set1, Set<String> set2, Set<String> wordList, boolean forward, HashMap<String, String>[] h) {
        if (set1.size() > set2.size())
            return dfs(set2, set1, wordList, !forward, h);
        
        int dir = forward ? 1 : 0;
        wordList.removeAll(set1);
        wordList.removeAll(set2);
        Set<String> set3 = new HashSet();
        
        for (String i : set1) {
            char[] ci = i.toCharArray();
            for (int j = 0; j < ci.length; j++) {
                char t = ci[j];
                for (char c = 'a'; c <= 'z'; c++) if (c != t) {
                    ci[j] = c;
                    String cand = new String(ci);
                    if (set2.contains(cand)) {
                        h[dir].put(cand, i);
                        return cand;
                    }
                    if (wordList.contains(cand)) {
                        h[dir].put(cand, i);
                        set3.add(cand);
                    }
                }
                ci[j] = t;
            }
        }
        
        return set3.size() > 0 ? dfs(set3, set2, wordList, forward, h) : null;
    }
}