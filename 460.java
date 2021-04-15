class LFUCache {
    TreeMap<Integer, Node> freqMap = new TreeMap();
    Map<Integer, Node> keyMap = new HashMap();
    int capacity;
    public LFUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!keyMap.containsKey(key)) return -1;
        upFreq(key);
        return keyMap.get(key).val;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        validate(key);
        upFreq(key);
        keyMap.get(key).val = value;  
        
    }
    
    private void validate(int key) {
        if (keyMap.size() < capacity || keyMap.containsKey(key)) return;
        int lowKey = freqMap.firstKey();
        Node root = freqMap.get(lowKey);
        int currkey = root.next.key;
        keyMap.remove(currkey);
        root.remove(root.next);
        if (root == root.next) {
            freqMap.remove(lowKey);
        }
    }
    
    private void upFreq(int key) {
        Node node = keyMap.getOrDefault(key,new Node(key));
        if (keyMap.containsKey(key)) {
            Node root = freqMap.get(node.freq);
            root.remove(node);
            if (root.next == root) {
                freqMap.remove(node.freq);
            }
        }         
        node.freq++;
        Node newRoot = freqMap.getOrDefault(node.freq, new Node(-1));
        newRoot.add(node);
        freqMap.put(node.freq, newRoot);
        keyMap.put(key,node);
    }
    
    class Node{
        int key;
        int val;
        Node pre;
        Node next;
        int freq = 0;
        Node(int key) {
            this.key = key;
            this.next = this;
            this.pre = this;
        }
        void remove(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    
        void add(Node node) {
            Node last = this.pre;
            last.next = node;
            node.pre = last;
            this.pre = node;
            node.next = this;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */