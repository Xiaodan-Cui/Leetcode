class Solution {
    public boolean isValidSerialization(String preorder) {
        if (preorder.length() == 0) return true;
        
        String[] strs = preorder.split(",");
        Stack<Character> stack = new Stack();
       
        for(String str : strs) {
            if(stack.size() == 1 && stack.peek() == '#') {
                return false;
            }
            if (!str.equals("#")) {
                stack.push('d');
            }
            else{
                while(!stack.isEmpty() && stack.peek() == '#') {
                    stack.pop();
                    stack.pop();
                }
                stack.push('#'); 
            }
        }
       
        return stack.size() == 1 && stack.pop() == '#';
    }
}