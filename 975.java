class Solution {
    Map<Integer, Boolean> oddMap = new HashMap();
    Map<Integer, Boolean> evenMap = new HashMap();
    int[] eol;
    int[] eos;
    public int oddEvenJumps(int[] arr) {
        if (arr.length == 1) return 1;
        oddMap.put(arr.length - 1, true);
        evenMap.put(arr.length - 1, true);
        //next >=
        eol = new int[arr.length];
        //next <=
        eos = new int[arr.length];
        TreeMap<Integer, Integer> treeMap = new TreeMap();
        treeMap.put(100001, arr.length);
        treeMap.put(-1, arr.length);
        for(int i = arr.length - 1; i >= 0; i--) {
            eol[i] = treeMap.get(treeMap.ceilingKey(arr[i]));
            eos[i] = treeMap.get(treeMap.floorKey(arr[i]));
            treeMap.put(arr[i], i);
        }
        int res = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (canReach(arr, i, 1)) {
                res++;
            }
        }
        return res;
    }
    
    private boolean canReach(int[] arr, int start, int number) {
        if (start == arr.length) return false;
        if (number % 2 == 0 && evenMap.containsKey(start) ) {
            return evenMap.get(start);
        }
        if (number % 2 == 1 && oddMap.containsKey(start) ) {
            return oddMap.get(start);
        }
        if (number % 2 == 0 ) {
            boolean reach = canReach (arr, eos[start], number + 1);
            evenMap.put(start, reach);
            return reach;
        }
        else{
            boolean reach = canReach (arr, eol[start], number + 1);
            oddMap.put(start, reach);
            return reach;
        }
    }
}