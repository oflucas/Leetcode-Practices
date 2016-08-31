// Total Accepted: 2444
// Total Submissions: 8233
// Difficulty: Hard
// 152ms ?%

public class RandomizedCollection {
    ArrayList<Integer> a;
    HashMap<Integer, Set<Integer>> loc;
    java.util.Random rand;
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        a = new ArrayList();
        loc = new HashMap();
        rand = new java.util.Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean has = loc.containsKey(val);
        Set<Integer> set = has ? loc.get(val) : new LinkedHashSet();
        set.add(a.size());
        a.add(val);
        loc.put(val, set);
        return !has;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!loc.containsKey(val)) return false;
        
        int i = loc.get(val).iterator().next();
        loc.get(val).remove(i);
        
        if (i < a.size() - 1) {
            int last = a.get(a.size() - 1);
            a.set(i, last);
            loc.get(last).remove(a.size() - 1);
            loc.get(last).add(i);
        }
        
        a.remove(a.size() - 1);
        if (loc.get(val).isEmpty()) loc.remove(val);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return a.get(rand.nextInt(a.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */