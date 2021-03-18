class Solution {
    public boolean makesquare(int[] nums) {
        if(nums.length<4) return false;
        int sum=0;
        for(int n:nums) sum+=n;
        if(sum%4!=0) return false;
        int l=sum/4;   
        Integer[] cnums=new Integer[nums.length];
        for(int i=0;i<nums.length;i++){
            cnums[i]=nums[i];
        }
        Arrays.sort(cnums,new Comparator<Integer>(){
            @Override
            public int compare(Integer a,Integer b){
                return b-a;
            }
        });
        if(cnums[0]>l) return false;
        Set<Integer> visited=new HashSet();
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(!bfs(l,cnums,0,0,visited)) return false;
            count++;
            if(count==3) return true;
        }
        return false;
    }
    private boolean bfs(int l,Integer[] nums,int t, int start,Set<Integer> visited){
        if(start==nums.length && t!=l) return false;
        if(t==l){
            return true;
        }
        if(!visited.contains(start)){
            visited.add(start);
            if(bfs(l,nums,t+nums[start],start+1,visited)){
                return true;
            };
            visited.remove(start);
        }
        if(bfs(l,nums,t,start+1,visited)){
            return true;
        }
        return false;
    }
}