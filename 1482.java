class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k>bloomDay.length) return -1;
        int min=bloomDay[0];
        int max=bloomDay[0];
        for(int b:bloomDay){
            min=Math.min(min,b);
            max=Math.max(max,b);
        }
        return binarySearch(bloomDay,min,max,m,k);
    }
    private int binarySearch(int[] bloomDay, int min, int max,int m,int k){
        if(min>=max) return min;
        int mid=min+(max-min)/2;
        int i=0;            
        int j=0;
        int count=0;
        while(j<bloomDay.length){
            if(bloomDay[j]<=mid){                    
                j++;
                if(j-i==k){
                    count++;
                    i=j;
                }
            }                
            else{
                j++;
                i=j;
            }
        }
        if(count>=m) {
            return binarySearch(bloomDay,min,mid,m,k);
        }
        else{
            return binarySearch(bloomDay,mid+1,max,m,k);
        }
            
    }
}