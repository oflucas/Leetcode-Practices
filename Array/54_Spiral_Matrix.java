//54_Spiral_Matrix.java
//1ms 70% Total Accepted: 63048 Total Submissions: 274341 Difficulty: Medium
public class Solution {
    private final static int[] dy = {0, 1, 0, -1};
    private final static int[] dx = {1, 0, -1, 0};
    private final static int nDir = 4;
    
    public List<Integer> spiralOrder(int[][] g) {
        if (g.length < 1) return new ArrayList();
        int n = g.length, m = g[0].length;
        List<Integer> ans = new ArrayList();
        for (int i = 0, y = 0, x = 0, d = 0; i < n * m; i++) {
            ans.add(g[y][x]);
            g[y][x] = Integer.MIN_VALUE;
            if (!possible(y + dy[d], x + dx[d], n, m, g)) 
                d = (d + 1) % nDir;
            y += dy[d]; x += dx[d];
        }
        return ans;
    }
    
    private boolean possible(int y, int x, int n, int m, int[][] g) {
        return !(y >= n || y < 0 || x >= m || x < 0 || g[y][x] == Integer.MIN_VALUE);
    }
}
