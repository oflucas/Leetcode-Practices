// Total Accepted: 27317
// Total Submissions: 72169
// Difficulty: Medium
// 2ms 99.8%

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        char[] cin = input.toCharArray();
        int n = cin.length;
        List<Integer>[][] h = new List[n][n];
        dfs(0, n - 1, cin, h);
        return h[0][n - 1];
    }
    
    private void dfs(int st, int ed, char[] cin, List<Integer>[][] h) {
        if (h[st][ed] != null) return;
        
        h[st][ed] = new ArrayList();
        boolean isNum = true;
        for (int i = st + 1; i < ed; i++)
            if (cin[i] == '+' || cin[i] == '-' || cin[i] == '*') {
                isNum = false;
                dfs(st, i - 1, cin, h);
                dfs(i + 1, ed, cin, h);
                char op = cin[i];
                for (int a : h[st][i - 1])
                    for (int b : h[i + 1][ed])
                        h[st][ed].add(cal(a, b, op));
            }
        
        if (isNum)
            h[st][ed].add(Integer.valueOf(String.valueOf(cin, st, ed - st + 1)));
    }
    
    private int cal(int a, int b, char op) {
        switch (op) {
            case '+' : return a + b;
            case '-' : return a - b;
            case '*' : return a * b;
            default : return 0;
        }
    }
}