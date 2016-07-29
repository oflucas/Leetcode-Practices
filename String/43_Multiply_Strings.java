// Total Accepted: 68681
// Total Submissions: 281623
// Difficulty: Medium
// 8ms 85%

public class Solution {
    public String multiply(String num1, String num2) {
        char[] cnum1 = num1.toCharArray(), cnum2 = num2.toCharArray();
        int len1 = cnum1.length, len2 = cnum2.length, lans = len1 + len2;
        int[] a = new int[len1], ans = new int[lans];
        for (int i = 0; i < len1; i++)
            a[i] = (int)(cnum1[len1 - 1 - i] - '0');
        
        for (int k = 0; k < len2; k++) {
            int[] t = mult(a, (int)(cnum2[len2 - 1 - k] - '0'), k);
            addTo(ans, t);
        }
        
        for (; lans > 1 && ans[lans - 1] == 0; lans--);
        char[] ansc = new char[lans];
        for (int i = 0; i < lans; i++)
            ansc[i] = (char)(ans[lans - 1 - i] + '0');
        return new String(ansc);
    }
    
    private void addTo(int[] a, int[] b) {
        int na = a.length, nb = b.length, carry = 0;
        for (int i = 0; i < na; i++) {
            a[i] += carry + (i < nb ? b[i] : 0);
            carry = a[i] / 10;
            a[i] = a[i] % 10;
        }
    }
    
    private int[] mult(int[] a, int b, int ofst) {
        int la = a.length, lres = la + 1 + ofst, carry = 0;
        int[] res = new int[lres];
        
        for (int i = 0; i < la + 1; i++) {
            int t = carry + b * (i < la ? a[i] : 0);
            res[i + ofst] = t % 10;
            carry = t / 10;
        }
        return res;
    }
}