class Solution {
    List<List<String>> res=new ArrayList();
    public List<List<String>> partition(String s) {
        if(s.length()==0){return res;}
        boolean[][] isPal= new boolean[s.length()][s.length()];
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i;j<s.length();j++){
                if(j==i){
                    isPal[i][j]=true;
                }
                else if (s.charAt(i)==s.charAt(j) &&(isPal[i+1][j-1] || j==i+1)){
                    isPal[i][j]=true;
                }
            }
        }
        
        backtrack(0,new ArrayList(),s,isPal);
        return res;
    }
    private void backtrack(int start,List<String> list,String s,boolean[][] isPal){
        if(start==s.length()){
            res.add(new ArrayList(list));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(isPal[start][i]){
                list.add(s.substring(start,i+1));
                backtrack(i+1,list,s,isPal);
                list.remove(list.size()-1);
            }
        }
    }
}