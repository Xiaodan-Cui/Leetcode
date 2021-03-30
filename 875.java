class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       
        //int min=piles[0];
        int max=piles[0];
        for(int p:piles){
            //min=Math.min(p,min);
            max=Math.max(p,max);
        }
        return binarySearch(piles,1,max,h);
    }
    private int binarySearch(int[] piles,int start,int end,int h){
        if(start>=end) return start;
        int mid=start+(end-start)/2;
        int count=0;
        for(int i=0;i<piles.length;i++){
            count+=(piles[i]+mid-1)/mid;
        }
        
        if(count<=h) return binarySearch(piles,start,mid,h);
        return binarySearch(piles,mid+1,end,h);
        
    }
}