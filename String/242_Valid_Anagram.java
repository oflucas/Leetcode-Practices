// Total Accepted: 97663
// Total Submissions: 226355
// Difficulty: Easy
// 3ms 97%


public class Solution {
    public boolean isAnagram(String s, String t) {
        char[] cs = s.toCharArray(), ct = t.toCharArray();
        if (cs.length != ct.length) return false;
        int[] cnt = new int[26];
        for (int i = 0; i < cs.length; i++) {
            cnt[cs[i] - 'a']++;
            cnt[ct[i] - 'a']--;
        }
        
        for (int i = 0; i < 26; i++)
            if (cnt[i] != 0) return false;
        return true;
    }
}