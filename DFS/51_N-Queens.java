//51_N-Queens.java
//4ms 98.4% Total Accepted: 56571 Total Submissions: 214447 Difficulty: Hard
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[] ocpC = new boolean[n], ocpDL = new boolean [2 * n - 1], ocpDR = new boolean[2 * n - 1];
        char[][] map = new char[n][n];
        for (char[] i : map)
            Arrays.fill(i, '.');
        List<List<String>> ans = new ArrayList();
        fillRow(0, ocpC, ocpDL, ocpDR, map, ans);
        return ans;
    }
    
    private void fillRow(int row, boolean[] ocpC, boolean[] ocpDL, boolean[] ocpDR, char[][] map,  List<List<String>> ans) {
        int n = ocpC.length;
        if (row == n) {
            writeOutput(map, ans);
            return;
        }
        
        for (int j = 0; j < n; j++)
            if (!ocpC[j] && !ocpDL[row + j] && !ocpDR[j - row + n - 1]) {
                map[row][j] = 'Q';
                ocpC[j] = true; ocpDL[row + j] = true; ocpDR[j - row + n - 1] = true;
                fillRow(row + 1, ocpC, ocpDL, ocpDR, map, ans);
                ocpC[j] = false; ocpDL[row + j] = false; ocpDR[j - row + n - 1] = false;
                map[row][j] = '.';
            }
    }
    
    private void writeOutput(char[][] map,  List<List<String>> ans) {
        List<String> res = new ArrayList();
        for (char[] s : map)
            res.add(new String(s));
        ans.add(res);
    }
}
