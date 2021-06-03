class Solution {
    Set<String> res = new HashSet();
    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        for(int i = 0; i < s.length();i++){
            if (s.charAt(i) =='(') left++;
            else if(s.charAt(i) == ')'){
                if (left != 0) left--;
                else right++;
            }
        }
        dfs(s, left, right, 0, new StringBuilder());
        return new ArrayList(res);
    }
    private void dfs(String s, int left, int right, int start, StringBuilder sb){
        if (start == s.length()){
            if (left == 0 && right == 0 && isValid(sb)){
                res.add(sb.toString());
            }
            return;
        }
        if (s.charAt(start) == '(' && left > 0){
            dfs(s, left - 1, right, start + 1, sb);
        }
        else if(s.charAt(start) == ')' && right > 0){
            dfs(s, left, right - 1, start + 1, sb);
        }
        sb.append(s.charAt(start));
        dfs(s, left, right, start + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
    }
    private boolean isValid(StringBuilder sb){
        int left = 0;
        for(int i = 0; i < sb.length(); i++){
            if (sb.charAt(i) == '(') left++;
            else if (sb.charAt(i) == ')'){
                if (left == 0) return false;
                left--;
            }
        }
        return left == 0;
    }
    
}