// Total Accepted: 24571
// Total Submissions: 49544
// Difficulty: Easy
// 10ms 32%

public class Solution {
    public char findTheDifference(String s, String t) {
        char[] cs = s.toCharArray(), ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        int i = 0;
        for (; i < cs.length && cs[i] == ct[i]; i++);
        return ct[i];
    }

 //    Others' Solution
 //    public char findTheDifference(String s, String t) {
    
 //    int num = 0;
 //    for (char c : s.toCharArray()) {
 //        num ^= (c - 'a');
 //    }
    
 //    for (char c : t.toCharArray()) {
 //        num ^= (c - 'a');
 //    }
    
 //    return (char)('a' + num);
	// }
}