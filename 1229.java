class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        List<Integer> res=new ArrayList();
        Arrays.sort(slots1,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                if(a[0]>=b[0]) return 1;
                return -1;
            }
        });
            Arrays.sort(slots2,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                if(a[0]>=b[0]) return 1;
                return -1;
            }
        });
        int i=0;
        int j=0;
        int end=0;
        while(true){
            if(i==slots1.length && j==slots2.length){
                return res;
            }
            else if(j==slots2.length 
                    || i!=slots1.length && slots1[i][0]<=slots2[j][0]){
                if((Math.min(slots1[i][1],end)-slots1[i][0])>=duration){
                    res.add(slots1[i][0]);
                    res.add(slots1[i][0]+duration);
                    return res;
                }
                end=Math.max(slots1[i][1],end);
                i++;
            }
            else{
                if((Math.min(slots2[j][1],end)-slots2[j][0])>=duration){
                    System.out.println(Math.min(slots2[j][1],end));
                    res.add(slots2[j][0]);
                    res.add(slots2[j][0]+duration);
                    return res;
                }
                end=Math.max(slots2[j][1],end);
                j++;
            }
        }
    }
}