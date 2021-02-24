class WordDictionary {

    /** Initialize your data structure here. */
    class Node{
        boolean isKey;
        Map<Character,Node> map;
        Node(){
            isKey=false;
            map=new HashMap();
        }
    }
    Node root;
    public WordDictionary() {
        root=new Node();
    }
    
    public void addWord(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++){
            if(curr.map.containsKey(word.charAt(i))){
                curr=curr.map.get(word.charAt(i));
            }
            else{
                Node node=new Node();
                curr.map.put(word.charAt(i),node);
                curr=node;
            }
        }
        curr.isKey=true;
    }
    
    public boolean search(String word) {
        return searchHelper(word,root,0);
    }
    private boolean searchHelper(String word, Node root,int i){
        if(i==word.length()-1){
            if(root.map.containsKey(word.charAt(i))){
                return root.map.get(word.charAt(i)).isKey;
            }
            else if(word.charAt(i)=='.'){
                for(char c: root.map.keySet()){
                    if(root.map.get(c).isKey){
                        return true;
                    }
                }
            }
            return false;
        }
        if(root.map.containsKey(word.charAt(i))){
            return searchHelper(word,root.map.get(word.charAt(i)),i+1);
        }
        else if(word.charAt(i)=='.'){
            for(char c: root.map.keySet()){
                if(searchHelper(word,root.map.get(c),i+1)){
                    return true;
                }
            }
        }
        return false;
             
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */