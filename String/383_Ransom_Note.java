// Total Accepted: 4422
// Total Submissions: 9627
// Difficulty: Easy
// 14ms ?%

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] rs = ransomNote.toCharArray(), mgz = magazine.toCharArray();
        int[] cnt = new int[26];
        for (char i : mgz) cnt[i - 'a']++;
        for (char i : rs) 
            if (--cnt[i - 'a'] < 0) return false;
        return true;
    }
}