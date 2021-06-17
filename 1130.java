class Solution {
    public int mctFromLeafValues(int[] arr) {
        Stack<Integer> stack = new Stack();
        int sum = 0;
        for(int a : arr){
            while (stack.size() > 0 && stack.peek() <= a){
                int mid = stack.pop();
                if (stack.size() > 0 && stack.peek() < a){
                    sum+= stack.peek() * mid;
                }
                else sum += a * mid;
            }
            stack.push(a);
        }
        while(stack.size() > 1){
            sum += stack.pop() * stack.peek();
        }
        return sum;
    }
}