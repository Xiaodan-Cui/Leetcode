class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap();
        Map<Integer, Integer> map2 = new HashMap();
        for(int n : nums1){
            map1.put(n, map1.getOrDefault(n, 0) + 1);
        }
        for(int n : nums2){
            map2.put(n, map2.getOrDefault(n, 0) + 1);
        }
        int res = 0;
        for(int n1 : map1.keySet()){
            for(int n2 : map2.keySet()){
                if (n1 == n2){
                    res += map1.get(n1) * (map2.get(n2) * (map2.get(n2) - 1) / 2);
                    res += map2.get(n2) * (map1.get(n1) * (map1.get(n1) - 1) / 2);
                }
                if (n1 > n2 && n1 * n1 % n2 == 0){
                    int n3 = n1 * n1 / n2;
                    if (map2.containsKey(n3)){
                        res += map1.get(n1) * map2.get(n2) * map2.get(n3);
                    }
                }
                if (n2 > n1 && n2 * n2 % n1 == 0){
                    int n3 = n2 * n2 /n1;
                    if (map1.containsKey(n3)){
                        res += map1.get(n1) * map2.get(n2) * map1.get(n3);
                    }
                }
            }
        }
        return res;
    }
}