class AutocompleteSystem {
    Map<String, Integer> map;
    TrieNode root;
    String prefix;
    TrieNode trie;
    public AutocompleteSystem(String[] sentences, int[] times) {
        map=new HashMap();
        root=new TrieNode();
        for(int i=0;i<times.length;i++){
            map.put(sentences[i],times[i]);
        }
        for(String str:sentences){
            insert(str);
        }
        prefix="";
        trie=root;
    }
    public List<String> input(char c) {
        if(c=='#'){
            int freq=map.getOrDefault(prefix,0)+1;
            map.put(prefix,freq);
            TrieNode upd=root;
            for(int i=0;i<prefix.length();i++){
                upd=upd.next.get(prefix.charAt(i));
                PriorityQueue<String> pq=upd.words;
                if(pq.contains(prefix)){pq.remove(prefix);}
                pq.add(prefix);
                if(pq.size()>3){
                    pq.poll();
                }
            }
            prefix="";
            trie=root;
            return new ArrayList();
        }
        prefix+=c;
        if(trie.next.containsKey(c)){
            trie=trie.next.get(c);
            PriorityQueue<String> pq=new PriorityQueue(trie.words);
            List<String> res=new ArrayList();
            while(pq.size()>0){
                res.add(0,pq.poll());
            }
            return res;
        }
        else{
            trie.next.put(c,new TrieNode());
            trie=trie.next.get(c);
            return new ArrayList();
        }
    }
    class TrieNode{
        Map<Character,TrieNode> next;
        PriorityQueue<String> words;
        TrieNode(){
            next=new HashMap();
            words=new PriorityQueue(new Comparator<String>(){
                @Override
                public int compare(String a,String b){
                    if(map.get(a)!=map.get(b)){
                        return map.get(a)-map.get(b);
                    }
                    return b.compareTo(a);
                }
            });
        }
    }
    private void insert(String word){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            if(!curr.next.containsKey(word.charAt(i))){
                curr.next.put(word.charAt(i),new TrieNode());
            }
            curr=curr.next.get(word.charAt(i));
            curr.words.add(word);
            if(curr.words.size()>3){
                curr.words.poll();
            }
        }
    }
}