class WordFilter {
    class TrieNode{
        TrieNode[] next;
        List<Integer> indexes;
        TrieNode(){
            next=new TrieNode[26];
            indexes=new ArrayList();
        }
    }
    TrieNode preTrie = new TrieNode();
    TrieNode sufTrie = new TrieNode();
    public WordFilter(String[] words) {
        for(int i=words.length-1;i>=0;i--){
            insertPre(words[i],i);
            insertSuf(words[i],i);
        }
    }
    private void insertPre(String word, int i){
        TrieNode curr=preTrie;
        for(int j=0;j<word.length();j++){
            if(curr.next[word.charAt(j)-'a']==null){
                curr.next[word.charAt(j)-'a']=new TrieNode();
            }
            curr=curr.next[word.charAt(j)-'a'];
            curr.indexes.add(i);
        }
    }
    private void insertSuf(String word, int i){
        TrieNode curr=sufTrie;
        for(int j=word.length()-1;j>=0;j--){
            if(curr.next[word.charAt(j)-'a']==null){
                curr.next[word.charAt(j)-'a']=new TrieNode();
            }
            curr=curr.next[word.charAt(j)-'a'];
            curr.indexes.add(i);
        }
    }
    
    public int f(String prefix, String suffix) {
        List<Integer> pre=searchPre(prefix);
        List<Integer> suf=searchSuf(suffix);
        if(pre==null || suf==null){
            return -1;
        }
        for(int i=0;i<suf.size();i++){
            if(pre.contains(suf.get(i))){
                return suf.get(i);
            }
        }
        return -1;
    }
    private List<Integer> searchPre(String prefix){
        TrieNode curr=preTrie;
        for(int j=0;j<prefix.length();j++){
            if(curr.next[prefix.charAt(j)-'a']==null){
                return null;
            }
            curr=curr.next[prefix.charAt(j)-'a'];
        }
        return curr.indexes;
    }
    private List<Integer> searchSuf(String suffix){
        TrieNode curr=sufTrie;
        for(int j=suffix.length()-1;j>=0;j--){
            if(curr.next[suffix.charAt(j)-'a']==null){
                return null;
            }
            curr=curr.next[suffix.charAt(j)-'a'];
        }
        return curr.indexes;
    }
    

}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */