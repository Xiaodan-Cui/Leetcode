class Solution {
    List<String> list = new ArrayList();
    public List<String> generateParenthesis(int n) {
        backtrack(n,new StringBuilder(),0,0);
        return list;
    }
    private void backtrack(int n,StringBuilder sb,int l,int r){
        if(sb.length()==2*n && l==n){
            list.add(sb.toString());
            return;
        }
        if(l<r || l>n){
            return;
        }
        backtrack(n, sb.append('('),l+1,r);
        sb.deleteCharAt(sb.length()-1);
        backtrack(n, sb.append(')'),l,r+1);
        sb.deleteCharAt(sb.length()-1);
        
    }
}