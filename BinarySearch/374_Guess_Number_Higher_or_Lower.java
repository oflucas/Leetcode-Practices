// Total Accepted: 15412
// Total Submissions: 49153
// Difficulty: Easy
// 1ms 100%

/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int i = 1, j = n;
        while (i < j) {
            int mid = i + (j - i) / 2, res = guess(i + (j - i) / 2);
            if (res == 0) break;
            if (res > 0) i = mid + 1; else j = mid - 1;
        }
        return i + (j - i) / 2;
    }
}