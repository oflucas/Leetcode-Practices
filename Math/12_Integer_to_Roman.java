// 8ms 73% Total Accepted: 66625 Total Submissions: 168452 Difficulty: Medium
public class Solution {
    char[] tens = {'I', 'X', 'C', 'M'};
    char[] fivs = {'V', 'L', 'D', '*'};
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 3, div = 1000, rm = num; i >= 0; div /= 10, i--) {
            int n = rm / div; rm %= div;
            if (n > 0) {
                if (n == 9)
                    sb.append(tens[i]).append(tens[i + 1]);
                else
                if (n >= 5) {
                    sb.append(fivs[i]);
                    for (int j = 6; j <= n; j++)
                        sb.append(tens[i]);
                } else
                if (n == 4)
                    sb.append(tens[i]).append(fivs[i]);
                else
                    for (int j = 1; j <= n; j++)
                        sb.append(tens[i]);
            }
        }
        return sb.toString();
    }
}
