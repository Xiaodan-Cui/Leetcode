class Solution {
    class TrieNode{
        TrieNode[] next;
        TrieNode(){           
           next=new TrieNode[2];
         }
    }
    
    TrieNode root=new TrieNode();
    
    private void insert(int num){
        TrieNode curr=root;
        for(int i=30;i>=0;i--){
            int d=(num & (1<<i)) ==0?0:1;
            if(curr.next[d]==null){
                curr.next[d]=new TrieNode();
            }
            curr=curr.next[d];
        }
    }
    private int helper(int num){
        int res=0;
        TrieNode curr=root;
         for(int i=30;i>=0;i--){
             int d=(num & (1<<i)) ==0?0:1;
            if(curr.next[1-d]!=null){
                res+=1<<i;
                curr=curr.next[1-d];
            }
             else{
                curr=curr.next[d];
             }
        }
        return res;
    }
    
    public int findMaximumXOR(int[] nums) {
       for(int num:nums){
           insert(num);
       }
        int max=0;
        for(int num:nums){
            max=Math.max(max,helper(num));
        }
        return max;
        
    }
}