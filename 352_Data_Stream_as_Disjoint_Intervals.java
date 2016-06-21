// Total Accepted: 2060 Total Submissions: 5726 Difficulty: Hard
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
        UnionFindSet uf = new UnionFindSet();
        if (uf != null) System.out.println("uf is not null");
        uf.find(0);
    }
    
    public void addNum(int val) {
        System.out.println("addnum: " + val);
        if (uf.find(val) != 0) return; // already has an interval
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
        HashMap<Integer, Interval> intv;
        
        public UnionFindSet() {
            System.out.println("uf built");
            path = new HashMap();
            intv = new HashMap();
        }
        
        public int mkInterv(int val) {
            path.put(val, val);
            intv.put(val, new Interval(val, val));
            return val;
        }
        
        public int find(int val) {
            System.out.println("uf finding - " + val);
            if (!path.containsKey(val)) return 0;
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
            if (i1 == 0 || i2 == 0) return; // merge fail
            if (size(i1) > size(i2)) {
                path.put(i2, i1);
                Interval y = intv.get(i1), y1 = intv.get(i2);
                y.start = Math.min(y.start, y1.start);
                y.end = Math.max(y.end, y1.end);
                intv.remove(i2);
            } else {
                path.put(i1, i2);
                Interval y = intv.get(i2), y1 = intv.get(i1);
                y.start = Math.min(y.start, y1.start);
                y.end = Math.max(y.end, y1.end);
                intv.remove(i1);
            }
        }
        
        public List<Interval> getIntervs() {
            return new ArrayList(intv.values());
        }
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
