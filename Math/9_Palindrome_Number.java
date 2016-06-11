//12ms 48% Total Accepted: 128020 Total Submissions: 398732 Difficulty: Easy
public class Solution {
    public boolean isPalindrome(int x) {
        int y = 0;
        for (int i = x; i > 0; i /= 10) y = y * 10 + i % 10;
        return y == x;
    }
}
