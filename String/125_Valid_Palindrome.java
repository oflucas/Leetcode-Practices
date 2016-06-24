//125_Valid_Palindrome.java
//8ms 90% Total Accepted: 106570 Total Submissions: 441257 Difficulty: Easy
public class Solution {
    public boolean isPalindrome(String s) {
        char[] c = s.toCharArray();
        for (int i = 0, j = c.length - 1; i <= j; i++, j--) {
            while (i <= j && !Character.isLetterOrDigit(c[i])) i++;
            while (i <= j && !Character.isLetterOrDigit(c[j])) j--;
            if (i <= j && Character.toLowerCase(c[i]) != Character.toLowerCase(c[j]))
                return false;
        }
        return true;
    }
}
