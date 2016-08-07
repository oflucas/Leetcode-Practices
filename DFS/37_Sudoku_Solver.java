// Total Accepted: 54958
// Total Submissions: 210702
// Difficulty: Hard
// 8ms 88%

public class Solution {
	public final static int N = 9;

    public void solveSudoku(char[][] b) {
        boolean[][] ocpC = new boolean[N][N], ocpR = new boolean[N][N], ocpS = new boolean[N][N];

        for (int i = 0; i < N; i++)
        	for (int j = 0; j < N; j++)
        		if (b[i][j] != '.')
        			fill(i, j, b[i][j], b, ocpC, ocpR, ocpS);

        dfs(0, b, ocpC, ocpR, ocpS);
    }

    public boolean dfs(int depth, char[][] b, boolean[][] ocpC, boolean[][] ocpR, boolean[][] ocpS) {
    	if (depth == N * N)
    		return true;

    	int i = depth / N, j = depth % N;
    	if (b[i][j] != '.') 
    		return dfs(depth + 1, b, ocpC, ocpR, ocpS);

    	for (char num = '1'; num <= (char)(N + '0'); num++)
    		if (validMove(i, j, num, b, ocpC, ocpR, ocpS)) {
    			fill(i, j, num, b, ocpC, ocpR, ocpS);
    			if (dfs(depth + 1, b, ocpC, ocpR, ocpS))
    				return true;
    			unfill(i, j, b, ocpC, ocpR, ocpS);
    		}

    	return false;
    }

    public void fill(int i, int j, char x, char[][] b, boolean[][] ocpC, boolean[][] ocpR, boolean[][] ocpS) {
    	b[i][j] = x;
    	int num = (int)(x - '1');
    	ocpC[j][num] = true;
    	ocpR[i][num] = true;
    	ocpS[i / 3 * 3 + j / 3][num] = true;
    }

    public void unfill(int i, int j, char[][] b, boolean[][] ocpC, boolean[][] ocpR, boolean[][] ocpS) {
    	char x = b[i][j];
    	b[i][j] = '.';
    	int num = (int)(x - '1');
    	ocpC[j][num] = false;
    	ocpR[i][num] = false;
    	ocpS[i / 3 * 3 + j / 3][num] = false;
    }

    public boolean validMove(int i, int j, char x, char[][] b, boolean[][] ocpC, boolean[][] ocpR, boolean[][] ocpS) {
    	int num = (int)(x - '1');
    	return b[i][j] == '.' &&  !ocpC[j][num] && !ocpR[i][num] && !ocpS[i / 3 * 3 + j / 3][num];
    }
}