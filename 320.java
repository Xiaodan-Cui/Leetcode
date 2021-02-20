class Solution {
    Set<String> res=new HashSet();
    public List<String> generateAbbreviations(String word) {
        backtrack(word,0,new StringBuilder());
        return new ArrayList<String>(res);
    }
    private void backtrack(String word,int start,StringBuilder sb){
        if(start==word.length()){
            res.add(sb.toString());
            return;
        }
        for(int i=start+1;i<=word.length();i++){
            if(sb.length()==0 || sb.charAt(sb.length()-1)>'9' 
               ||sb.charAt(sb.length()-1)<'0' ){
                sb.append(i-start);
                backtrack(word,i,sb);
                while(sb.length()>0 && Character.isDigit(sb.charAt(sb.length()-1))){
                    sb.deleteCharAt(sb.length()-1);
                }
            }
            sb.append(word.substring(start,i));
            backtrack(word,i,sb);
            sb.delete(sb.length()+start-i,sb.length());
        }
    }
}