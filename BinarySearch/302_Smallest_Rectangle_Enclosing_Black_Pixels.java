// Total Accepted: 6895
// Total Submissions: 16716
// Difficulty: Hard
// 5ms 20%

public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int n = image.length, m = image[0].length;
        int[] row = new int[n], col = new int[m];
        boolean[][] visited = new boolean[n][m];
        int[] udlr = new int[4];
        udlr[1] = Integer.MAX_VALUE;
        udlr[2] = Integer.MAX_VALUE;
        findBd(image, x, y, udlr, visited);
        return (udlr[0] - udlr[1] + 1) * (udlr[3] - udlr[2] + 1);
    }
    
    private void findBd(char[][] g, int x, int y, int[] udlr, boolean[][] visited) {
        if (x < 0 || x == g.length || y < 0 || y == g[0].length || g[x][y] == '0' || visited[x][y]) return;
        visited[x][y] = true;
        udlr[0] = Math.max(udlr[0], x);
        udlr[1] = Math.min(udlr[1], x);
        udlr[2] = Math.min(udlr[2], y);
        udlr[3] = Math.max(udlr[3], y);
        for (int i = 0; i < 4; i++)
            findBd(g, x + dx[i], y + dy[i], udlr, visited);
    }
    
    private final static int[] dx = {0,1,0,-1};
    private final static int[] dy = {1,0,-1,0};
}