// 58_Length_of_Last_Word.java
// 0ms 100% Total Accepted: 99188 Total Submissions: 333058 Difficulty: Easy
public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int id = s.lastIndexOf(' ');
        return id < 0 ? s.length() : s.length() - id - 1;
    }
}
