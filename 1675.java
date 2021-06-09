class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer> treeset = new TreeSet();
        for(int n : nums){
           if (n % 2 == 1){
             treeset.add(2 * n);   
           }
            else treeset.add(n);
        }
        if (treeset.size() == 1) return 0;
        int res = treeset.last() - treeset.first();
        while(true){
            int first = treeset.first();
            int last = treeset.last();
            res = Math.min(res, last - first);
            if (last % 2 == 1) return res;
            treeset.remove(last);
            treeset.add(last / 2);
        }

       
    }
}