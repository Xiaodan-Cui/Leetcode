class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int max=0;
        int sum=0;
        for(int w:weights){
            max=Math.max(w,max);
            sum+=w;
        }
        return binarySearch(weights,max,sum,D);
    }
    private int binarySearch(int[] weights, int start, int end, int D){
        if(start>=end) return start;
        int mid=start+(end-start)/2;
        int j=0;
        int sum=0;
        int count=1;
        while(j<weights.length){
            sum+=weights[j];
            if(sum>mid){
                count++;
                sum=weights[j];
            }
            j++;
        }
        if(count>D) return binarySearch(weights,mid+1,end,D);
        return binarySearch(weights,start,mid,D);
    }
}