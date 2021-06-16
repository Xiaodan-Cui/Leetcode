class Solution {
    public int longestWPI(int[] hours) {
        Stack<Integer> stack = new Stack();
        int[] sum = new int[hours.length + 1];
        for(int i = 1; i < sum.length; i++){
            if (hours[i - 1] > 8) sum[i] = sum[i - 1] + 1;
            else sum[i] = sum[i - 1] - 1;
        }
        stack.push(0);
        for(int i = 1; i < sum.length; i++){
            if (sum[i] < sum[stack.peek()]) stack.push(i);
        }
        int max = Integer.MIN_VALUE;
        int res = 0;
        for(int i = sum.length - 1; i > 0; i--){
            if (sum[i] > max){
                //System.out.println(i + " " + stack.size() + " " + sum[i]);
                while(stack.size() > 0 && sum[stack.peek()] < sum[i]){
                    res = Math.max(i - stack.pop(), res);
                    //System.out.println(1);
                }
                max = sum[i];
            }
        }
        return res;
    }
}