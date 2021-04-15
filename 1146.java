class SnapshotArray {
    Map<Integer,TreeMap<Integer, Integer>> map = new HashMap();
    int snap_id = 0;
    int[] array;
    public SnapshotArray(int length) {
        array = new int[length];
        for(int i = 0; i < length; i++) {
            TreeMap<Integer,Integer> curr = new TreeMap();
            curr.put(0, 0);
            map.put(i,curr);
        }
    }
    
    public void set(int index, int val) {
        array[index] = val;
        TreeMap<Integer, Integer> curr = map.get(index);
        curr.put(snap_id, val);
    }
    
    public int snap() {
        return snap_id++;
    }
    
    public int get(int index, int snap_id) {
        TreeMap<Integer,Integer> curr = map.get(index);

        return curr.get(curr.floorKey(snap_id));
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */