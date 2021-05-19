class Solution {
    public boolean checkValidString(String s) {
        Stack<Character> stack = new Stack();
        int l = 0;
        int star = 0;
        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                stack.push('(');
                l++;
            }
            else if (s.charAt(i) == '*'){
                stack.push('*');
                star++;
            }
            else{
                if(l == 0 && star == 0) return false;
                if(l == 0) {
                    stack.pop();
                    star--;
                }
                else{
                    int count = 0;
                    while(stack.peek() == '*'){
                        stack.pop();
                        count++;
                    }
                    stack.pop();
                    l--;
                    for(int j = 0; j< count;j++){
                        stack.push('*');
                    }
                }
            }
        }
        if (l > star) return false;
        int count = 0;
        while(l > 0){
            while(!stack.isEmpty() && stack.peek() == '*'){
                stack.pop();
                count++;
            }
            while(!stack.isEmpty() && stack.peek() == '('){
                stack.pop();
                count--;
                l--;
            }
            if (count < 0) return false;
        }
        return true;
    }   
}