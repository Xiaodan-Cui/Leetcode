class Solution {
    public int balancedString(String s) {
        Map<Character,Integer> map=new HashMap();
        int n=s.length();
        int res=n;
        int sum=0;
        int i=0;
        int j=0;
        map.put('Q',0);
        map.put('W',0);
        map.put('E',0);
        map.put('R',0);
        for(int k=0;k<n;k++){
            map.put(s.charAt(k),map.get(s.charAt(k))+1);
        }
        for(char c:map.keySet()){
            if(map.get(c)>n/4){
                sum+=map.get(c)-n/4;
            }
            map.put(c,map.get(c)-n/4);
        }
        if(sum==0) return 0;
        int target=sum;
        while(j<n){
            while(sum>0 && j<n){
                if(map.get(s.charAt(j))>0){
                    sum--;
                }
                map.put(s.charAt(j),map.get(s.charAt(j))-1);
                j++;
            }
            while(sum==0 && map.get(s.charAt(i))<0){
                System.out.println(s.charAt(i));
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
                i++;
            }
            res=Math.min(res,j-i);
            if(res==target) return res;
            map.put(s.charAt(i),map.get(s.charAt(i))+1);
            i++;
            sum++;
        }
        return res;
        
    }
}