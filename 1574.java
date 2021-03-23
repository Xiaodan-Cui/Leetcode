class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        if(arr.length<=1) return 0;
        int left=0;
        int right=arr.length-1;
        while(left<arr.length-1 && arr[left+1]>=arr[left] ){
            left++;
        }
        if(left==arr.length-1) return 0;
        while(arr[right-1]<=arr[right]){
            right--;
            //System.out.println(left+"  "+right);
        }
        //System.out.println(left+"  "+right);
        int min=Math.min(arr.length-left-1,right);
        int i=0;
        int j=right;
        while(i<=left){
            while(j<arr.length && arr[j]<arr[i] ){
                j++;
            }
            min=Math.min(min,j-i-1);
            i++;
        }
        return min;
    }
}