// Total Accepted: 18528
// Total Submissions: 52130
// Difficulty: Medium
// 29ms 71%

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;
        int[] cnt = new int[m], num = new int[n];
        num[0] = 1;

        for (int i = 1; i < n; i++) {
        	int min = num[cnt[0]] * primes[0], jmin = 0;
        	for (int j = 1; j < m; j++)
        		if (num[cnt[j]] * primes[j] < min) {
        			min = num[cnt[j]] * primes[j];
        			jmin = j;
        		}

        	num[i] = min;

        	for (int j = 0; j < m; j++)
        		if (num[cnt[j]] * primes[j] == min)
        			cnt[j]++;
        }

        return num[n - 1];
    }
}