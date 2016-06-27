// 168_Excel_Sheet_Column_Title.java
// 0ms 100% Total Accepted: 65203 Total Submissions: 291534 Difficulty: Easy
public class Solution {
    private int DIV = 26;
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        for (; n > 0; n = (n - 1) / DIV)
            sb.append((char)((n - 1) % DIV + 'A'));
        return sb.reverse().toString();
    }
}
