// 202_Happy_Number.java
// 6ms 50% Total Accepted: 76010 Total Submissions: 203748 Difficulty: Easy
public class Solution {
    public boolean isHappy(int n) {
        int i = n, sum = 0;
        HashMap<Integer, Boolean> h = new HashMap();
        h.put(n, true);
        do {
            h.put(sum, true);
            sum = 0;
            for (; i > 0; i /= 10) 
                sum += (i % 10) * (i % 10);
            i = sum;
        } while (!h.containsKey(i) && i != 1);
        return i == 1;
    }
}
