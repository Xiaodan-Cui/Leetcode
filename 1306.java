class Solution {
    Map<Integer, Boolean> map = new HashMap();
    Set<Integer> visited = new HashSet();
    public boolean canReach(int[] arr, int start) {
        if (visited.contains(start)) return false;
        if (start < 0 || start > arr.length -1) return false;
        if (map.containsKey(start)) return map.get(start);
        if (arr[start] == 0) {
            map.put(start, true);
            return true;
        }
        int left = start - arr[start];
        int right = start + arr[start];
        visited.add(start);
        if (canReach(arr, left) || canReach(arr,right)) {
            map.put(start, true);
            return true;
        }
        map.put(start, false);
        return false;
    }
}