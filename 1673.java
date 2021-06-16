class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < nums.length; i++){
            if (stack.size() + nums.length - i == k) {
                stack.push(nums[i]);
                continue;
            }
            while(stack.size() != 0 && stack.peek() > nums[i] 
                  && stack.size() + nums.length - i > k){
                stack.pop();
            }
            stack.push(nums[i]);
        }
        while(stack.size() > k) stack.pop();
        int[] res = new int[k];
        for(int i = k - 1; i >= 0; i--){
            res[i] = stack.pop();
        }
        return res;
    }
}