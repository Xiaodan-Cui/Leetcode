class RandomizedCollection {

    /** Initialize your data structure here. */
    Map<Integer, PriorityQueue<Integer>> map = new HashMap();
    Random rand = new Random();
    List<Integer> list = new ArrayList();
    public RandomizedCollection() {
        
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) {
            PriorityQueue<Integer> pq = map.get(val);
            pq.add(list.size());
            list.add(val);
            return false;
        }
        else{
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a,b)->b-a);
            pq.add(list.size());
            map.put(val, pq);
            list.add(val);
            return true;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        PriorityQueue<Integer> pq = map.get(val);
        int index = pq.poll();
        if(pq.isEmpty()) map.remove(val);
        if(index != list.size() - 1) {
            int last = list.get(list.size() - 1);
            list.set(index, last);
            PriorityQueue<Integer> pql = map.get(last);
            pql.poll();
            pql.add(index);
        }
        list.remove(list.size() - 1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */