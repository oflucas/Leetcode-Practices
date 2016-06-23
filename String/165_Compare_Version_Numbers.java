// 2ms 85% Total Accepted: 56660 Total Submissions: 316093 Difficulty: Easy
public class Solution {
    private final static char DOT = '.';
    public int compareVersion(String v1, String v2) {
        int p1 = 0, p2 = 0, n1 = v1.indexOf(DOT, p1), n2 = v2.indexOf(DOT, p2), l1 = v1.length(), l2 = v2.length();
        for (; p1 < l1 || p2 < l2; n1 = v1.indexOf(DOT, p1), n2 = v2.indexOf(DOT, p2)) {
            if (n1 < 0) n1 = l1;
            if (n2 < 0) n2 = l2;
            int t1 = (p1 >= l1) ? 0 : Integer.valueOf(v1.substring(p1, n1)); 
            int t2 = (p2 >= l2) ? 0 : Integer.valueOf(v2.substring(p2, n2));
            if (t1 > t2) return 1;
            if (t1 < t2) return -1;
            p1 = n1 + 1; p2 = n2 + 1;
        }
        
        return 0;
    }
}
