/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public Node expTree(String s) {
        if (s.length() == 0) return null;
        Stack<Node> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(new Node('('));
                continue;
            }
            if (s.charAt(i) == '*' || s.charAt(i) == '/' 
                ||s.charAt(i) == '+' || s.charAt(i) == '-') {
                Node temp = new Node(s.charAt(i)); 
                temp.left = stack.pop();
                stack.push(temp);
                continue;
            }
            Node temp;
            if (s.charAt(i) == ')') {
                temp = stack.pop();
                stack.pop();
                if(stack.isEmpty()) {
                    stack.push(temp);
                    continue;
                }
            }
            else{
                temp = new Node(s.charAt(i));
                if(stack.isEmpty() || stack.peek().val == '(') {
                    stack.push(temp);
                    continue;
                }
            }
            while(!stack.isEmpty()){
                if (stack.peek().val == '*' || stack.peek().val == '/') {
                    Node curr = stack.pop();
                    curr.right = temp;
                    temp = curr;
                }
                else if ( (stack.peek().val == '+' || stack.peek().val == '-')
                    && (i == s.length()-1 || s.charAt(i + 1) == '+' 
                        || s.charAt(i+1) == '-'||s.charAt(i+1) == ')')){
                        Node curr = stack.pop();
                        curr.right = temp;
                        temp = curr;
                }
                else {
                    break;
                }
            }
            stack.push(temp);
        }
        return stack.pop();  
    }
}