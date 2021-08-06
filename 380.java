class RandomizedSet {

    /** Initialize your data structure here. */
    Map<Integer, Integer> locations = new HashMap();
    List<Integer> numList = new ArrayList();
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (locations.containsKey(val)) return false;
        locations.put(val, numList.size());
        numList.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!locations.containsKey(val)) return false;
        int loc = locations.get(val);
        if (loc == locations.size() - 1){
            locations.remove(val);
            numList.remove(numList.size() - 1);
            return true;
        }
        int last = numList.get(numList.size() - 1);
        locations.put(last, loc);
        locations.remove(val);
        numList.remove(loc);
        numList.add(loc, last);
        numList.remove(numList.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        return numList.get(rand.nextInt(numList.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */