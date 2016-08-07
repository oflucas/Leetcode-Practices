// Total Accepted: 13278
// Total Submissions: 30797
// Difficulty: Easy
// 14ms 74%

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public boolean canAttendMeetings(Interval[] inv) {
        Arrays.sort(inv, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        if (inv.length < 2) return true;
        for (int i = 1, ed = inv[0].end; i < inv.length; i++) {
            if (ed > inv[i].start) return false;
            ed = inv[i].end;
        }
        return true;
    }
}