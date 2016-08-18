// Total Accepted: 28266
// Total Submissions: 106575
// Difficulty: Medium
// 14ms 95%

public class Solution {
    public int calculate(String s) {
        char[] ch = s.toCharArray();
        // prev (prevOp) cur (curOp) t
        int t = 0, cur = 0, prev = 0, ans = 0;
        char curOp = '+', prevOp = '+';
        for (char c : ch) {
            if (Character.isDigit(c))
                t = 10 * t + (int)(c - '0');
            else 
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                if (curOp == '+' || curOp == '-') {
                    prev = operate(prev, cur, prevOp);
                    prevOp = curOp;
                    cur = t;
                } else
                    cur = operate(cur, t, curOp);
                curOp = c;
                t = 0;
            }
            //System.out.println(prev + " " + prevOp + " " + cur + " " + curOp);   
        }
        
        if (curOp == '+' || curOp == '-') {
                    cur = operate(prev, cur, prevOp);
                    ans = operate(cur, t, curOp);
                } else {
                    cur = operate(cur, t, curOp);
                    ans = operate(prev, cur, prevOp);
                }
        return ans;
    }
    
    private int operate(int a, int b, char op) {
        switch (op) {
            case '+' : return a + b;
            case '-' : return a - b;
            case '*' : return a * b;
            case '/' : return a / b;
            default  : return a + b;
        }
    }
}