class Solution {
    public int rectangleArea(int[][] rectangles) {
        long sum=0;
        int[][] intervals=new int[rectangles.length*2][3];
        int i=0;
        for(int[] rec:rectangles){
            intervals[i][0]=rec[1];
            intervals[i][1]=1;
            intervals[i][2]=i/2;
            intervals[i+1][0]=rec[3];
            intervals[i+1][1]=-1;
            intervals[i+1][2]=i/2;
            i+=2;
        }
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        Set<Integer> active=new HashSet();
        int currentY=intervals[0][0];
        for(int j=0;j<intervals.length;j++){
            if(active.size()==0) currentY=intervals[j][0];
            if(intervals[j][0]!=currentY && active.size()>0){
                List<int[]> list= new ArrayList();
                for(int s:active){
                    list.add(rectangles[s]);
                }
                Collections.sort(list,(a,b)->a[0]-b[0]);
                int h_total=0;
                int start=list.get(0)[0];
               //System.out.println(start);
                int end=list.get(0)[2];
                for(int k=1;k<list.size();k++){
                    if(list.get(k)[0]>end){
                        h_total+=end-start;
                        start=list.get(k)[0];
                        end=list.get(k)[2];
                    }
                    else{
                        end=Math.max(end,list.get(k)[2]);
                    }
                }
                h_total+=end-start;
                //System.out.println(active.size()+" "+intervals[j][0]+" "+currentY+" "+start+" "+end+" "+h_total);
                sum+=((long) h_total)*(intervals[j][0]-currentY);
                sum%=1000000007;
                currentY=intervals[j][0];
            }
            if(intervals[j][1]==1){
                    active.add(intervals[j][2]);
            }
            else{
                 //System.out.println(2+"  "+);
                active.remove(intervals[j][2]);
            }
           //System.out.println(active.size()+" "+intervals[j][3]);
            
        }
        return (int)sum;
        
    }
}
