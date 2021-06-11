class Solution {
    public int findBestValue(int[] arr, int target) {
         Arrays.sort(arr);
        long[] sum = new long[arr.length + 1];
        for(int i = 1; i < sum.length; i++){
            sum[i] = arr[i - 1] + sum[i - 1];
        }
        if (target >= sum[arr.length]) return arr[arr.length - 1];
        int ave = target / arr.length;
        if (ave <= arr[0]) {
            int sum1 = ave * arr.length;
            int sum2 = (ave + 1) * arr.length;
            if (sum2 - target < target - sum1) return ave + 1;
            return ave;
        }
        int mid = binarySearch(arr, 0, arr.length - 2, sum, target);
        //System.out.println(mid);
        long leftSum = sum[mid + 1];
        //System.out.println(leftSum);
        long num = (int)((target - leftSum) / (arr.length - mid - 1));
        //System.out.println(num);
        long sum1 = num * (arr.length - mid - 1) + leftSum;
        long sum2 = (num + 1)* (arr.length - mid - 1) + leftSum;
        if (sum2 - target < target - sum1) return (int)num + 1;
        return (int)num;
    }
    
    private int binarySearch(int[] arr,int start, int end, long[] sum, int target){
        if (start >= end) return end;
        int mid = start + (end - start) / 2;
        long leftSum = sum[mid + 1];
        long num = (int) ((target - leftSum) / (arr.length - mid - 1));
        if (num >= arr[mid] && num <= arr[mid + 1]) return mid;
        if (num < arr[mid]) return binarySearch(arr, start, mid - 1,sum, target);
        return binarySearch(arr, mid + 1, end,sum, target);
    }
    
}