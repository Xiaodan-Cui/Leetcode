class Solution {
    int[] preSum;
    int sum;
    Random rand = new Random();
    public Solution(int[] w) {
        preSum = new int[w.length];
        for(int i = 1; i < w.length; i++){
            preSum[i] = preSum[i - 1] + w[i - 1];
        }
        sum = preSum[w.length - 1] + w[w.length - 1];
    }
    
    public int pickIndex() {
        int temp = rand.nextInt(sum);
        return bs(preSum, temp, 0, preSum.length - 1);
    }
    
    private int bs(int[] preSum, int temp, int start, int end){
        if (preSum[start] > temp) return start - 1;
        if (preSum[end] <= temp) return end;
        int mid = start + (end - start) / 2;
        if (preSum[mid] == temp) return mid;
        if (preSum[mid] < temp) return bs(preSum, temp, mid + 1, end);
        return bs(preSum, temp, start, mid - 1);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */