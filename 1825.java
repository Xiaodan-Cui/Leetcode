class MKAverage {
    class Group{
        TreeMap<Integer, Integer> map;
        int size;
        int sum;
        public Group(){
            map = new TreeMap();
            size = 0;
            sum = 0;
        };
        public Integer getFirst(){
            return map.firstKey();
        }
        public Integer getLast(){
            return map.lastKey();
        }
        public int getSize(){
            return size;
        }
        public int getSum(){
            return sum;
        }
        public void add(int num){
            map.put(num, map.getOrDefault(num, 0) + 1);
            size++;
            sum += num;
        }
        public void remove(int num){
            int count = map.get(num);
            if (count == 1) map.remove(num);
            else map.put(num, count - 1);
            size--;
            sum -= num;
        }
    }
    
    Group midGroup = new Group();
    Group loGroup = new Group();
    Group hiGroup = new Group();
    Queue<Integer> queue = new LinkedList();
    int m;
    int k;
    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
    }
    
    public void addElement(int num) {
        queue.add(num);
        if (queue.size() > m && num < midGroup.getFirst()) loGroup.add(num);
        else if (queue.size() > m && num > midGroup.getLast()) hiGroup.add(num);
        else midGroup.add(num);
        if (queue.size() > m){
            int out = queue.poll();
            if (out < midGroup.getFirst()) loGroup.remove(out);
            else if (out > midGroup.getLast()) hiGroup.remove(out);
            else midGroup.remove(out);
        }
        if (queue.size() == m){
            arrange(loGroup, midGroup, k);
            arrange(midGroup, hiGroup, m - 2 * k);
        }
        
    }
    
    public int calculateMKAverage() {
        if (queue.size() < m) return -1;
        return midGroup.getSum() / (m - 2 * k);
    }
    
    private void arrange(Group a, Group b, int k){
        while(a.getSize() > k){
            int out = a.getLast();
            b.add(out);
            a.remove(out);
        }
        while(a.getSize() < k){
            int out = b.getFirst();
            a.add(out);
            b.remove(out);
        }
    }
}

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */