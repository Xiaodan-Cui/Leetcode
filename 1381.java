class CustomStack {
    Stack<Integer> stack = new Stack();
    int maxSize;
    int[] inc;
    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        inc = new int[maxSize + 1];
    }
    
    public void push(int x) {
        if (stack.size() < maxSize){
            stack.push(x);
        }
    }
    
    public int pop() {
        if (stack.size() == 0) return -1;
        int net = inc[stack.size()];
        inc[stack.size() - 1] += net;
        inc[stack.size()] = 0;
        return stack.pop() + net;
    }
    
    public void increment(int k, int val) {
        int i = Math.min(k, stack.size());
        inc[i] += val; 
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */