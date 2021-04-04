class Solution {
    public int maximizeSweetness(int[] sweetness, int K) {
        int sum=0;
        int min=100001;
        for(int s:sweetness){
            sum+=s;
            min=Math.min(min,s);
        }
        return binarySearch(sweetness,K+1,min,sum/(K+1));
    }
    private int binarySearch(int[] sweetness, int N, int min, int max){
        if(min>max) return max;
        int mid=min+(max-min)/2;
        int K=0;
        int sum=0;
        for(int i=0;i<sweetness.length;i++){
            sum+=sweetness[i];
            if(sum>=mid){
                K++;
                sum=0;
            }
        }
        if(K<N) return binarySearch(sweetness,N,min,mid-1);
        else return binarySearch(sweetness,N,mid+1,max);
        //else return binarySearch(sweetness,N,mid,max);
    }
}