import java.util.*;
class RangeModule {
    TreeMap<Integer, Integer> treeMap;
    public RangeModule() {
        treeMap = new TreeMap();
        treeMap.put(-1, -1);
        treeMap.put(1000000009, 1000000009);
    }
    
    public void addRange(int left, int right) {
        int before = treeMap.floorKey(left);
        if (treeMap.get(before) >= right) return;
        if (treeMap.ceilingKey(right) == right) right = treeMap.get(right);
        SortedMap<Integer, Integer> subMap = treeMap.subMap(left, right);
        if (subMap.size() > 0){
            if (subMap.get(subMap.lastKey()) > right) right = subMap.get(subMap.lastKey());
            for(int key : new HashSet<Integer>(subMap.keySet())){
                treeMap.remove(key); 
            } 
        }
        before = treeMap.floorKey(left);
        if (treeMap.get(before) >= left){
            left = before;
        }
        treeMap.put(left, right);
    }
    
    public boolean queryRange(int left, int right) {
        int before = treeMap.floorKey(left);
        return treeMap.get(before) >= right;
    }
    
    public void removeRange(int left, int right) {
        SortedMap<Integer, Integer> subMap = treeMap.subMap(left, right);
        if (subMap.size() > 0){
            if (subMap.get(subMap.lastKey()) > right){
                treeMap.put(right,subMap.get(subMap.lastKey()));
            } 
            for(int key : new HashSet<Integer>(subMap.keySet())){
                treeMap.remove(key); 
            } 
        } 
        int before = treeMap.floorKey(left);
        if (treeMap.get(before) > left){
            if (treeMap.get(before) > right) treeMap.put(right, treeMap.get(before));
            treeMap.put(before, left);
        }
    }
}

/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */