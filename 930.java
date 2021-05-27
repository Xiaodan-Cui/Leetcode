class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        List<Integer> list = new ArrayList();
        list.add(-1);
        for(int i = 0; i < nums.length;i++){
            if (nums[i] == 1) list.add(i);
        }
        list.add(nums.length);
        int res = 0;
        if (goal == 0) {
            for(int i = 1; i < list.size(); i++){
                res += (list.get(i) - list.get(i - 1) ) * (list.get(i) - list.get(i - 1) - 1) / 2; 
            }
        }
        else{
            for(int i = 1; i+ goal < list.size(); i++){
                res += (list.get(i) - list.get(i - 1) ) 
                    * (list.get(i + goal) - list.get(i + goal - 1));
            }
        }
        return res;
    }
}