// Total Accepted: 60834
// Total Submissions: 413847
// Difficulty: Hard
// 23ms 91%

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        int n = points.length;
        if (n < 3) return n;

        int ans = 0;
        HashMap<Double, Integer> h = new HashMap();
        for (int i = 0; i < n; i++) {
            h.clear();
            int vertLine = 0, samePoint = 1;
            for (int j = 0; j < i; j++) 
                if (points[j].x == points[i].x) {
                    if (points[j].y == points[i].y)
                        samePoint++;
                    else
                        vertLine++;
                } else {
                      Double sl = 1.0 * (points[j].y - points[i].y) / (points[j].x - points[i].x);
                      int cnt = h.containsKey(sl) ? h.get(sl) : 0;
                      h.put(sl, cnt + 1);
                }

            ans = Math.max(ans, vertLine + samePoint);
            for (int y : h.values())
                ans = Math.max(ans, y + samePoint);
        }

        return ans;
    }
}