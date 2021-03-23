
class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int sum=0;
        for(int i=0;i<grumpy.length;i++){
            sum+=(1-grumpy[i])*customers[i];
        }
        int start=0;
        int end=0;
        int max=0;
        int happy=0;
        while(start<grumpy.length){
            if(grumpy[start]==0){
                start++;
            }
            else{
                if(end<start) end=start;
                while(end-start<X && end<grumpy.length){
                    if(grumpy[end]==1){
                        happy+=customers[end];
                    }
                    end++;
                } 
                max=Math.max(happy,max);
                happy-=customers[start];
                start++;
            }
            //System.out.println(start);
        }
        return max+sum;
    }
}