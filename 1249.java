class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList();
        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '('){
                list.add(sb.length());
                sb.append('(');
            }
            else if(s.charAt(i) == ')'){
                if (list.size() > 0){
                    list.remove(0);
                    sb.append(')');
                }
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        for(int i =list.size() - 1; i >= 0; i--) {
            sb.deleteCharAt(list.get(i));
        }
        return sb.toString();
    }
}