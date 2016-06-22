//8ms 40% Total Accepted: 32770 Total Submissions: 107452 Difficulty: Easy
public class Solution {
    // Another method is bucket sort for pure digits inputs -> then count cow
    public String getHint(String secret, String guess) {
        char[] s = secret.toCharArray(), g = guess.toCharArray();
        int len = s.length, bull = 0, cow = 0;
        for (int i = 0; i < len; i++) if (s[i] == g[i]) {
            bull++;
            s[i] = '^';
            g[i] = '^';
        }
        Arrays.sort(s);
        Arrays.sort(g);
        for (int i = 0, j = 0; i < len && j < len;) {
            if (s[i] == '^' || g[j] == '^') break; // ^ must be at tail
            if (s[i] < g[j]) i++;
            else
            if (s[i] > g[j]) j++;
            else {
                cow++;
                i++;
                j++;
            }
        }
        return new StringBuilder().append(bull).append('A').append(cow).append('B').toString();
    }
}
