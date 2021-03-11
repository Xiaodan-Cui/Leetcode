class MyCalendarThree {
    Map<Integer,Integer> treeMap;
    public MyCalendarThree() {
        treeMap=new TreeMap();
    }
    
    public int book(int start, int end) {
        treeMap.put(start,treeMap.getOrDefault(start,0)+1);
        treeMap.put(end,treeMap.getOrDefault(end,0)-1);
        int max=0;
        int curr=0;
        for(int v:treeMap.values()){
            curr+=v;
            max=Math.max(curr,max);
        }
        return max;
        
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */