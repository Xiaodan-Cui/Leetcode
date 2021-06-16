class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack();
        stack.push(0);
        for(int i = 1; i < nums.length; i++){
            if (nums[i] < nums[stack.peek()]){
                stack.push(i);
            }
        }
        int max = -1;
        int res = 0;
        for(int i = nums.length -1; i >= 0 && i + 1 > res; i--){
            if (nums[i] > max){
                while(stack.size() > 0 && nums[i] >= nums[stack.peek()]){
                    res = Math.max(res, i - stack.pop());
                }
                max = nums[i];
            }
        }
        return res;
    }
}