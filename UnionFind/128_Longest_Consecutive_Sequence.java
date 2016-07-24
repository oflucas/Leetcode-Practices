// Total Accepted: 71103
// Total Submissions: 214166
// Difficulty: Hard
// 28ms 6%

public class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        UnionFind uf = new UnionFind();

        for (int i : nums)
        	ans = Math.max(ans, uf.build(i));

        return ans;
    }

    private class UnionFind {
    	private HashMap<Integer, Integer> p = new HashMap(), size = new HashMap();
    	private final static int NOTFOUND = Integer.MIN_VALUE;

    	public int find(int x) {
    		if (!p.containsKey(x))
    			return NOTFOUND;
    		
    		if (p.get(x) == x)
    			return x;
    		
    		int y = find(p.get(x));
    		p.put(x, y);
    		return y;
    	}

    	public void merge(int a, int b) {
    		a = find(a);
    		b = find(b);
    		int sza = size.get(a);
    		int szb = size.get(b);
    		if (sza > szb) {
    			p.put(b, a);
    			size.put(a, sza + szb);
    		} else {
    			p.put(a, b);
    			size.put(b, sza + szb);
    		}
    	}

    	public int build(int x) {
    		if (p.containsKey(x)) 
    			return 0;

    		p.put(x, x);
    		size.put(x, 1);

    		if (p.containsKey(x - 1)) merge(x - 1, x);
    		if (p.containsKey(x + 1)) merge(x, x + 1);

    		return size.get(find(x));
    	}
    }
}