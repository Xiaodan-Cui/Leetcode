class Solution {
    TrieNode root=new TrieNode();
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int[] res=new int[queries.length];
        int min=nums[0];
        for(int n:nums){
            min=Math.min(n,min);
            insert(n);
        }
        for(int i=0;i<res.length;i++){
            if(queries[i][1]<min){
                res[i]=-1;
                continue;
            }
            TrieNode curr=root;
            int sum=0;
            boolean withM=true;
            for(int j=30;j>=0;j--){
                int d=(queries[i][0] & (1<<j))==0?0:1;
                if((1<<j) >  queries[i][1]){
                    sum+=d*(1<<j);
                    curr=curr.next[0];
                }
                else if (withM){
                    if((queries[i][1] & (1<<j))!=0){
                        if(curr.next[1]==null || curr.next[1].value>queries[i][1]){
                            withM=false;
                            sum+=d*(1<<j);
                            curr=curr.next[0];
                        }  
                        else if(curr.next[0]!=null && d==1){
                            withM=false;
                            sum+=1<<j;
                            curr=curr.next[0];
                            //System.out.println(2);
                        }
                        else{
                            sum+=(1-d)*(1<<j);
                            curr=curr.next[1];
                            //System.out.println(13);
                        }
                    }
                    else{
                        sum+=d*(1<<j);
                        curr=curr.next[0];
                        //System.out.println(4);
                    }
                }
                else{
                    if(curr.next[1-d]!=null){
                        sum+=1<<j;
                        curr=curr.next[1-d];
                    }
                    else{
                        curr=curr.next[d];
                    }
                }
            }
            res[i]=sum;
        }
        return res;
    }
    private void insert(int num){
        TrieNode curr=root;
        for(int i=30;i>=0;i--){
            int d=(num & (1<<i))==0?0:1;
            if(curr.next[d]==null){
                curr.next[d]=new TrieNode();
            }
            curr=curr.next[d];
            if(d==1 && (curr.value==null || curr.value>num)){
                curr.value=num;
            }
        }
    }
    class TrieNode{
        TrieNode[] next;
        Integer value;
        TrieNode(){
            next=new TrieNode[2];
            value=null;
        }
    }
    
}