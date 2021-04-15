class AllOne {

    /** Initialize your data structure here. */
    TreeMap<Integer,Set<String>> countMap = new TreeMap();
    Map<String,Integer> map = new HashMap();
    public AllOne() {
        
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        int count = map.getOrDefault(key, 0);
        map.put(key, count + 1);
        Set<String> tempSet = countMap.getOrDefault(count + 1, new HashSet());
        tempSet.add(key);
        countMap.put(count + 1, tempSet);
        if (count !=0) {
            Set<String> set = countMap.get(count);
            set.remove(key);
            if (set.size() == 0){
                countMap.remove(count);
            }
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        int count = map.get(key);
        if (count == 1) map.remove(key);
        else map.put(key, count - 1);
        Set<String> set = countMap.get(count);
        set.remove(key);
        if (set.isEmpty()) countMap.remove(count);
        if (count != 1) {
            Set<String> tempSet = countMap.getOrDefault(count - 1, new HashSet());
            tempSet.add(key);
            countMap.put(count - 1, tempSet);
        } 
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if (map.isEmpty()) return "";
        Set<String> set = countMap.get(countMap.lastKey());
        for(String s: set) {
            return s;
        }
        return "";
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if (map.isEmpty()) return "";
        Set<String> set = countMap.get(countMap.firstKey());
        for(String s: set) {
            return s;
        }
        return "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */