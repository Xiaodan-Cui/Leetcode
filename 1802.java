class Solution {
    public int maxValue(int n, int index, int maxSum) {
        maxSum -= n;
        return 1 + helper(n, index, maxSum, 1, maxSum);
    }
    
    private int helper(int n, int index, int maxSum, int start, int end){
        if (start > end) return end;
        int mid = start + (end - start) / 2;
        long sum = findSum(n, mid, index);
        if (sum == maxSum) return mid;
        if (sum > maxSum) return helper(n, index, maxSum, start, mid - 1);
        return helper(n, index, maxSum, mid + 1, end);
    }
    
    private long findSum(int n, int mid, int index){
        long left = 0;
        long right = 0;
        if (mid > n - 1 - index){
            right = ((mid - 1) +(long) (mid - (n - 1 - index))) * (n - 1 - index) / 2;
        }
        else{
            right = (long)mid * (mid - 1)  / 2;
        }
        if (mid > index){
            left = ((long)(mid - 1) + (mid - index)) * index / 2;
        }
        else{
            left =(long) mid * (mid - 1) /2;
        }
        return left + right + mid;
    }
}