// Total Accepted: 18795
// Total Submissions: 95860
// Difficulty: Hard
// 4ms 98%

public class Solution {
    private static final String[] units = {"Hundred", "Thousand", "Million", "Billion"};
    private static final int[] unitv = {100, 1000, 1000000, 1000000000};
    private static final String[] digits = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    private static final String[] teens = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private static final String[] ties = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
        if (num == 0) 
            return digits[0];
            
        StringBuilder res = new StringBuilder();
        for (int i = unitv.length - 1; i > 0 && num > 0; i--)
            if (num / unitv[i] > 0) {
                res.append(gen_XXX(num / unitv[i])).append(" " + units[i]);
                num %= unitv[i];
                if (num > 0) res.append(" ");
            }
        res.append(gen_XXX(num));
        return res.toString();
    }
    
    private String gen_XXX(int x) {
        if (x <= 0) return "";
        String res = "";
        if (x / unitv[0] > 0) {
            res = res + digits[x / unitv[0]] + " " + units[0];
            x %= unitv[0];
            if (x == 0) 
                return res;
            res = res + " ";
        }
        
        if (x < 10) 
            res = res + digits[x];
        else
        if (x < 20)
            res = res + teens[x - 10];
        else {
            res = res + ties[x / 10];
            x %= 10;
            if (x > 0)
                res = res + " " + digits[x];
        }
        
        return res;
    }
}