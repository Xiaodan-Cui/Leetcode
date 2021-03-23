class Solution {
    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int res=0;
        for(int i=0;i<nums1.length;i++){
            int left=0;
            int right=nums2.length-1;
            while(left<right && nums2[left]<=nums1[i]){
                if(nums1[i]*nums1[i]<nums2[left]*nums2[right]){
                    right--;
                }
                else if(nums1[i]*nums1[i]>nums2[left]*nums2[right]){
                    left++;
                }
                else{
                    if(nums2[left]==nums2[right]){
                        res+=(right-left)*(right-left+1)/2;
                        break;
                    }
                    else{
                        int a=1;
                        int b=1;
                        while(nums2[left++]==nums2[left]){
                            a++;
                        }
                        while(nums2[right--]==nums2[right]){
                            b++;
                        }
                        res+=a*b;
                    }
                }
            }
        }
          for(int i=0;i<nums2.length;i++){
            int left=0;
            int right=nums1.length-1;
            while(left<right && nums1[left]<=nums2[i]){
                if(nums2[i]*nums2[i]<nums1[left]*nums1[right]){
                    right--;
                }
                else if(nums2[i]*nums2[i]>nums1[left]*nums1[right]){
                    left++;
                }
                else{
                    if(nums1[left]==nums1[right]){
                        res+=(right-left)*(right-left+1)/2;
                        break;
                    }
                    else{
                        int a=1;
                        int b=1;
                        while(nums1[left++]==nums1[left]){
                            a++;
                        }
                        while(nums1[right--]==nums1[right]){
                            b++;
                        }
                        res+=a*b;
                    }
                }
            }
        }
        return res;
    }
}