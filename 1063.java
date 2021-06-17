class Solution {
    public int validSubarrays(int[] nums) {
        Stack<int[]> stack = new Stack();
        int sum = 0;
        for(int i = nums.length - 1; i >= 0; i--){
            int count = 1;
            while(stack.size() > 0 && stack.peek()[0] >= nums[i]){
                count += stack.pop()[1];
            }
            sum += count;
            stack.push(new int[]{nums[i], count});
        }
        return sum;
    }
}