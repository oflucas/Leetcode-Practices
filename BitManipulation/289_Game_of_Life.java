// 289_Game_of_Life.java
// 1ms 90% Total Accepted: 21637 Total Submissions: 61811 Difficulty: Medium
public class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                int x = noOfNb(i, j, board);
                if (board[i][j] < 1) {
                    if (x == 3) board[i][j] |= 2;
                } else {
                    if (x > 1 && x < 4) board[i][j] |= 2;
                }
            }
        
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) board[i][j] >>= 1;
    }
    
    private int[][] dir = {{-1, 0},{-1, 1},{0, 1},{1, 1},{1, 0},{1, -1},{0, -1},{-1, -1}};
    
    private int noOfNb(int i, int j, int[][] b) {
        int sum = 0;
        for (int[] d : dir) {
            int y = i + d[0], x = j + d[1];
            if (y >= 0 && y < b.length && x >= 0 && x < b[0].length)
                sum += b[y][x] & 1;
        }
        return sum;
    }
}
