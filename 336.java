class Solution {
    TrieNode negTrie=new TrieNode();
    Map<String, Boolean> map=new HashMap();
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res=new ArrayList();
        Map<String, Boolean> map=new HashMap();
        for(int i=0;i<words.length;i++){
            insertNeg(words[i],i);
        }
        for(int i=0;i<words.length;i++){
            List<Integer> list=search(words[i],negTrie,words);
            for(int j=0;j<list.size();j++){
                List<Integer> c=new ArrayList();
                if(i!=list.get(j)){
                    c.add(i);
                    c.add(list.get(j));
                    res.add(c);
                }
            }
        }
        return res;
    }
    private List<Integer> search(String s, TrieNode negTrie,String[] words){
        List<Integer> list=new ArrayList();
        TrieNode curr=negTrie;
        if(s.length()==0){
            for(int i=0;i<words.length;i++){
                if(isPal(words[i],0,words[i].length()-1)){
                    list.add(i);
                }
            }
            return list;
        }
        if(s.length()!=0 && curr.keyIndex!=null){
            if(isPal(s,0,s.length()-1)){
                list.add(curr.keyIndex);
            }
        }
        for(int i=0;i<s.length();i++){
            if(curr.next[s.charAt(i)-'a']==null){
                return list;
            }
            curr=curr.next[s.charAt(i)-'a'];
            if(i!=s.length()-1 && curr.keyIndex!=null){
                if(isPal(s,i+1,s.length()-1)){
                    list.add(curr.keyIndex);
                }
            }
        }
        for(int i=0;i<curr.indexes.size();i++){
            if(isPal(words[curr.indexes.get(i)],0,words[curr.indexes.get(i)].length()-s.length()-1)){
                list.add(curr.indexes.get(i));   
            }
        }
        return list;
    }
    private boolean isPal(String s,int start,int end){
        String curr=s+"#"+start+"#"+end;
        if (map.containsKey(curr)){
            return map.get(curr);
        }
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                map.put(curr,false);
                return false;
            }
            end--;
            start++;
        }
        map.put(curr,true);
        return true;
    }
    class TrieNode{
        TrieNode[] next;
        Integer keyIndex;
        List<Integer> indexes;
        TrieNode(){
            next=new TrieNode[26];
            keyIndex=null;
            indexes=new ArrayList();
        }
    }
    private void insertNeg(String s, int idx){
        TrieNode curr=negTrie;
        if(s.length()==0){
            curr.keyIndex=idx;
            return;
        }
        for(int i=s.length()-1;i>=0;i--){
            if(curr.next[s.charAt(i)-'a']==null){
                curr.next[s.charAt(i)-'a']=new TrieNode();
            }
            curr=curr.next[s.charAt(i)-'a'];
            curr.indexes.add(idx);
        }
        curr.keyIndex=idx;
    }
}