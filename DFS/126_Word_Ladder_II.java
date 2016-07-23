// Total Accepted: 47479
// Total Submissions: 346809
// Difficulty: Hard
// 38ms 92%

public class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        HashMap<String, List<String>> p = new HashMap();
        List<List<String>> ans = new LinkedList();
        
        if (dfs(Collections.singleton(beginWord), Collections.singleton(endWord), wordList, p, true)) {
            List<String> cur = new LinkedList(Collections.singletonList(beginWord));
            getOutput(beginWord, endWord, p, cur, ans);
        }
        return ans;
    }

    private boolean dfs(Set<String> set1, Set<String> set2, Set<String> wordList, HashMap<String, List<String>> p, boolean forward) {
        if (set1.size() > set2.size())
            return dfs(set2, set1, wordList, p, !forward);
        if (set1.size() == 0)
            return false;

        wordList.removeAll(set1);
        wordList.removeAll(set2);

        boolean connected = false;
        Set<String> set3 = new HashSet();
        for (String str : set1) {
            char[] cstr = str.toCharArray();
            for (int j = 0; j < cstr.length; j++) {
                char t = cstr[j];
                for (char x = 'a'; x <= 'z'; x++) if (x != t) {
                    cstr[j] = x;
                    String cand = new String(cstr);
                    if (set2.contains(cand)) {
                        connected = true;
                        addPath(p, str, cand, forward);
                    } else
                    if (wordList.contains(cand)) {
                        set3.add(cand);
                        addPath(p, str, cand, forward);
                    }
                }
                cstr[j] = t;
            }
        }

        return connected || dfs(set3, set2, wordList, p, forward);
    }

    private void addPath(HashMap<String, List<String>> p, String fr, String to, boolean forward) {
        if (!forward) {
            addPath(p, to, fr, !forward);
            return;
        }
        List<String> li = (p.containsKey(fr)) ? p.get(fr) : new LinkedList();
        li.add(to);
        p.put(fr, li);
    }

    private void getOutput(String st, String ed, HashMap<String, List<String>> p, List<String> cur, List<List<String>> ans) {
        if (st.equals(ed)) {
            ans.add(new LinkedList(cur));
            return;
        }
        
        if (!p.containsKey(st)) return;
        
        List<String> neighbors = p.get(st);
        for (String i : neighbors) {
            cur.add(i);
            getOutput(i, ed, p, cur, ans);
            cur.remove(cur.size() - 1);
        }
    }
}
