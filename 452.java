class Solution {
    public int findMinArrowShots(int[][] points) {
        if(points.length<=1) return points.length;
        Arrays.sort(points,new Comparator<int[]> (){
            @Override
            public int compare(int[] a,int[] b){
                if(a[0]>b[0]) return 1;
                if(a[0]<b[0]) return -1;
                if(a[1]>b[1]) return 1;
                return -1;
            }
        });
        int max=points[0][1];
        int res=1;
        for(int i=1;i<points.length;i++){
           int[] p=points[i];
            if(p[0]>max){
                res+=1;
                max=p[1];
            }
            else max=Math.min(max,p[1]);
        }
        return res;
    }
}