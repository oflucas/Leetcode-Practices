// Total Accepted: 2500
// Total Submissions: 5116
// Difficulty: Medium
// 105ms 89%

public class HitCounter {
    private final static int WIN_SIZE = 300; //seconds
    private Deque<int[]> q; //int[] = {time stamp, hits};
    private int cnt;

    /** Initialize your data structure here. */
    public HitCounter() {
        cnt = 0;
        q = new LinkedList();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        cnt++;
        if (q.isEmpty() || q.peekLast()[0] != timestamp)
            q.offerLast(new int[] {timestamp, 1});
        else
            q.peekLast()[1]++;
        
        cleanOld(timestamp);
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        cleanOld(timestamp);
        return cnt;
    }
    
    private void cleanOld(int timestamp) {
        while (!q.isEmpty() && q.peekFirst()[0] <= timestamp - WIN_SIZE) {
            int[] t = q.pollFirst();
            cnt -= t[1];
        }
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */