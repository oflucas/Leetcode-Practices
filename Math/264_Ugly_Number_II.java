// Total Accepted: 36351
// Total Submissions: 122928
// Difficulty: Medium
// 19ms 46%

public class Solution {
	private final static int[] prime = {2, 3, 5};
    public int nthUglyNumber(int n) {
        int m = prime.length;
        int[] mult = new int[m];
        int[] ugly = new int[n];

        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
        	int min = Integer.MAX_VALUE;
        	for (int j = 0; j < m; j++)
        		min = Math.min(min, prime[j] * ugly[mult[j]]);
        	ugly[i] = min;
        	for (int j = 0; j < m; j++)
        		if (prime[j] * ugly[mult[j]] == min) mult[j]++;
        }

        return ugly[n - 1];
    }
}