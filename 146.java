class LRUCache {
    Map<Integer, Node> map = new HashMap();
    Node root;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        root = new Node(-1, 0);
        root.next = root;
        root.pre = root;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        add(node);
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            add(node);
        }
        else{
            Node node = new Node(key, value);
            map.put(key, node);
            add(node);
        }
        if (map.size() > capacity) {
            map.remove(root.next.key);
            remove (root.next);
        }
    }
    class Node{
        Node pre;
        Node next;
        int val;
        int key;
        Node(int key, int val){
            this.key = key;
            this.val =  val;
        }
    }
    private void remove(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    private void add(Node node){
        Node last = root.pre;
        last.next = node;
        node.pre = last;
        root.pre = node;
        node.next = root;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */