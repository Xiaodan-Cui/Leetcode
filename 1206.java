class Skiplist {
    class Node{
        Node next;
        Node base;
        int val;
        Node(int v){
            this.val = v;
        }
    }
    Node head;
    public Skiplist() {
        head = new Node(-1);
    }
    
    public boolean search(int target) {
        Node curr = head;
        while(curr != null){
            if (curr.next == null || curr.next.val > target) curr = curr.base;
            else if (curr.next.val == target) return true;
            else curr = curr.next;
        }
        return false;
    }
    
    public void add(int num) {
        Node curr = head;
        Node upper = null;
        Node newNode = new Node(num);
        while(curr != null){
            if (curr.next == null || curr.next.val > num) {
                upper = curr;
                curr = curr.base;
            }
            else if (curr.next.val == num) {
                curr = curr.next;
                break;
            }
            else curr = curr.next;
        }
        if (upper == null){
            Node temp = new Node(-1);
            temp.base = head;
            temp.next = newNode;
            newNode.base = curr;
            head = temp;
        }
        else{
            Node temp = upper.next;
            upper.next = newNode;
            newNode.base = curr;
            newNode.next = temp;
        }
    }
    
    public boolean erase(int num) {
        Node curr = head;
        while(curr != null){
            if (curr.next == null || curr.next.val > num) curr = curr.base;
            else if (curr.next.val == num) {
                Node toRemove = curr.next;
                curr.next = curr.next.next;
                toRemove.next = null;
                toRemove.base = null;
                return true;
            }
            else curr = curr.next;
        }
        return false;        
    }
}

/**
 * Your Skiplist object will be instantiated and called as such:
 * Skiplist obj = new Skiplist();
 * boolean param_1 = obj.search(target);
 * obj.add(num);
 * boolean param_3 = obj.erase(num);
 */