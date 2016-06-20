//48ms 50% Total Accepted: 26753 Total Submissions: 132196 Difficulty: Medium
public class WordDictionary {
    int SIZE = 26;
    private class Trie {
            Trie[] next = new Trie[SIZE];
            boolean isWord = false;
        }

    Trie root = new Trie();

    // Adds a word into the data structure.
    public void addWord(String word) {
        Trie j = root;
        for (int i = 0; i < word.length(); i++) {
            int id = word.charAt(i) - 'a';
            if (j.next[id] == null) j.next[id] = new Trie();
            j = j.next[id];
        }
        j.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return chk(0, word, root);
    }
    
    private boolean chk(int i, String word, Trie r) {
        if (r == null) return false;
        if (i >= word.length()) return r.isWord;
        
        if (word.charAt(i) == '.') {
            for (int j = 0; j < SIZE; j++)
                if (chk(i + 1, word, r.next[j])) return true;
        } else
            return chk(i + 1, word, r.next[word.charAt(i) - 'a']);
        return false;
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
