class Solution {
    public int maxSumMinProduct(int[] nums) {
        final int mod = (int) 1e9 + 7;
        long res = 0;
        Stack<Integer> left = new Stack();
        long[] sum = new long[nums.length + 1];
        int[] leftS = new int[nums.length];
        int[] rightS = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            while (left.size() > 0 && nums[left.peek()] >= nums[i]){
                left.pop();
            }
            leftS[i] = left.isEmpty() ? -1 : left.peek();
            left.push(i);
            sum[i + 1] = sum[i] + nums[i];
        }
        Stack<Integer> right = new Stack();
        for(int i = nums.length - 1; i >= 0 ;i--){
            while (right.size() > 0 && nums[right.peek()] >= nums[i]){
                right.pop();
            }
            
            rightS[i] = right.isEmpty() ? nums.length : right.peek();
            right.push(i);
        }
        for(int i = 0; i < nums.length; i++){
            res = Math.max(res, nums[i] * (sum[rightS[i]] - sum[leftS[i] + 1]));
        }
        return (int) (res % mod);
        
    }
}