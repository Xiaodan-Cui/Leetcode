class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list  = new ArrayList();
        list.add(new ArrayList());
        int pre = 0;
        for(int j = 0; j < nums.length; j++){
            if (j != 0 && nums[j] == nums[j - 1]){
                pre++;
            }
            else{
                pre = 0;
            }
            int s = list.size();
            for(int i = 0; i < s; i++){
                if (pre == 0 || list.get(i).size() >= pre 
                    && list.get(i).get(list.get(i).size() - pre) == nums[j]){
                    List<Integer> temp = new ArrayList(list.get(i));
                    temp.add(nums[j]);
                    list.add(temp);
                }
            }
        }
        return list;
    }
}