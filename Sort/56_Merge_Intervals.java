//56_Merge_Intervals.java
//14ms 90% Total Accepted: 70889 Total Submissions: 273387 Difficulty: Hard
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
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() < 2) 
            return intervals;
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        
        int st = intervals.get(0).start, ed = intervals.get(0).end;
        List<Interval> res = new ArrayList();
        for (Interval i : intervals)
            if (i.start <= ed)
                ed = Math.max(ed, i.end);
            else {
                res.add(new Interval(st, ed));
                st = i.start;
                ed = i.end;
            }
        res.add(new Interval(st, ed));
        
        return res;
    }
}
