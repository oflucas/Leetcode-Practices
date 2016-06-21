//250ms 20% Total Accepted: 2060 Total Submissions: 5726 Difficulty: Hard
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class SummaryRanges {
    UnionFindSet uf;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        uf = new UnionFindSet();
    }
    
    public void addNum(int val) {
        if (uf.find(val) >= 0) return; // already has an interval
        int i = uf.mkInterv(val);
        uf.merge(val, val - 1);
        uf.merge(val, val + 1);
    }
    
    public List<Interval> getIntervals() {
        return uf.getIntervs();
    }
    
    //////
    //  DataStructure Design
    /////
    public class UnionFindSet {
        HashMap<Integer, Integer> path;
        TreeMap<Integer, Interval> intv;
        
        public UnionFindSet() {
            path = new HashMap();
            intv = new TreeMap();
        }
        
        public int mkInterv(int val) {
            path.put(val, val);
            intv.put(val, new Interval(val, val));
            return val;
        }
        
        public int find(int val) {
            if (!path.containsKey(val)) return -1;
            int x = path.get(val);
            if (x == val) return val;
            int y = find(x);
            path.put(val, y);
            return y;
        }
        
        public int size(int i) {
            Interval y = intv.get(i);
            return y.end - y.start;
        }
        
        public void merge(int v1, int v2) {
            int i1 = find(v1), i2 = find(v2);
            if (i1 < 0 || i2 < 0) return; // merge fail
            if (size(i1) > size(i2)) mergeFrTo(i2, i1); else mergeFrTo(i1, i2);
        }
        
        public void mergeFrTo(int f, int t) {
            path.put(f, t);
            Interval y = intv.get(t), y1 = intv.get(f);
            y.start = Math.min(y.start, y1.start);
            y.end = Math.max(y.end, y1.end);
            intv.remove(f);
        }
        
        public List<Interval> getIntervs() {
            List<Interval> res = new ArrayList(intv.values());
            /*
            Collections.sort(res, new Comparator<Interval>() {
                @Override
                public int compare(Interval a, Interval b) {
                    return a.start - b.start;
                }
            });
            */
            return res;
        }
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
