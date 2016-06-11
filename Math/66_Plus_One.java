// 0ms 100% Total Accepted: 104570 Total Submissions: 305726 Difficulty: Easy
public class Solution {
    public int[] plusOne(int[] digits) {
        int c = 1, len = digits.length, k = 0;
        for (int j = len - 1; j >= 0 && c > 0; j--) {
            c = (++digits[j]) / 10;
            digits[j] %= 10;
        }
        if (c > 0) len++;
        int[] res = new int[len];
        if (c > 0) res[k++] = c;
        for (int j : digits) res[k++] = j;
        return res;
    }
}
