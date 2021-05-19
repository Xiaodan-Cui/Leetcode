class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack();

       for(int i = 0; i< s.length();i++){
            if (s.charAt(i) == '('){
                stack.push(0);
            }
            else{
                int curr = 0;
                if (stack.peek() == 0){
                    stack.pop();
                    curr = 1;
                }
                else{
                    curr = stack.pop() * 2;
                    stack.pop();
                }
                if (stack.size() > 0 && stack.peek() != 0){
                        curr+=stack.pop();
                    }
                stack.push(curr);
            }
        }
        return stack.pop();
    }
}