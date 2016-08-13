// Total Accepted: 24810
// Total Submissions: 120261
// Difficulty: Hard
// 20ms 89%

public class Solution {
    private class TrieNode {
        String word = null;
        TrieNode[] nxt = new TrieNode[26];
    }
    
    private class TrieTree {
        TrieNode root = new TrieNode();
        
        public void insert(String w) {
            char[] ch = w.toCharArray();
            TrieNode cur = root;
            for (char c : ch) {
                if (cur.nxt[c - 'a'] == null)
                    cur.nxt[c - 'a'] = new TrieNode();
                cur = cur.nxt[c - 'a'];
            }
            cur.word = w;
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList();
        TrieTree tt = new TrieTree();
        for (String w : words) tt.insert(w);
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                dfs(i, j, board, tt.root.nxt[board[i][j] - 'a'], ans);
        return ans;
    }
    
    private static final int[] dy = {0,1,0,-1};
    private static final int[] dx = {1,0,-1,0};
    
    private void dfs(int i, int j, char[][] b, TrieNode tn, List<String> ans) {
        if (tn == null) return;
        if (tn.word != null) {
            ans.add(tn.word);
            tn.word = null;
        }
        
        int n = b.length, m = b[0].length;
        char c = b[i][j];
        b[i][j] = '#';
        for (int k = 0; k < 4; k++) {
            int y = i + dy[k], x = j + dx[k];
            if (y >= 0 && y < n && x >= 0 && x < m && b[y][x] != '#')
                dfs(y, x, b, tn.nxt[b[y][x] - 'a'], ans);
        }
        b[i][j] = c;
    }
}