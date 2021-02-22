class Trie {

    //** Initialize your data structure here. **
    
    class TrieNode{
        TrieNode[] children;
        boolean isKey;
        TrieNode(){
            children = new TrieNode[26];
            isKey=false;
        }
    }
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            if(curr.children[word.charAt(i)-'a']==null){
                curr.children[word.charAt(i)-'a']=new TrieNode();
            }
            curr=curr.children[word.charAt(i)-'a'];
        }
        curr.isKey=true;
    }
    
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            if(curr.children[word.charAt(i)-'a']==null){
                return false;
            }
            curr=curr.children[word.charAt(i)-'a'];
        }
        return curr.isKey;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr=root;
        for(int i=0;i<prefix.length();i++){
            if(curr.children[prefix.charAt(i)-'a']==null){
                return false;
            }
            curr=curr.children[prefix.charAt(i)-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */