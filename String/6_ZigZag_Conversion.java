// Total Accepted: 97876
// Total Submissions: 396001
// Difficulty: Easy
// 5ms 96%

public class Solution {
    public String convert(String str, int numRows) {
        if (numRows <= 1) return str;
        char[] s = str.toCharArray(), res = new char[s.length];
        int len = s.length;

        for (int i = 0, k = 0; i < numRows; i++) {
        	for (int j = i; j < len; j += 2 * numRows - 2) {
        		res[k++] = s[j];
        		if (i != 0 && i < numRows - 1 && j + 2 * numRows - 2 - 2 * i < len)
        			res[k++] = s[j + 2 * numRows - 2 - 2 * i];
        	}
        }
        return new String(res);
    }
}