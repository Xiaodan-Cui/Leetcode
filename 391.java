class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int sumArea=0;
        Set<String> set=new HashSet();
        for(int[] rec:rectangles){
            sumArea+=Area(rec);
            String s1=rec[0]+" "+rec[1];
            String s2=rec[2]+" "+rec[3];
            String s3=rec[0]+" "+rec[3];
            String s4=rec[2]+" "+rec[1];
            if(set.contains(s1)) set.remove(s1);
            else set.add(s1);
            if(set.contains(s2)) set.remove(s2);
            else set.add(s2); 
            if(set.contains(s3)) set.remove(s3);
            else set.add(s3);
            if(set.contains(s4)) set.remove(s4);
            else set.add(s4); 
        }
        //System.out.println(sumArea);
        //System.out.println(set.size());
        if(set.size()!=4) return false;
        int[] recs=new int[4];
        int x0=Integer.MAX_VALUE;
        int x1=Integer.MIN_VALUE;
        int y0=Integer.MAX_VALUE;
        int y1=Integer.MIN_VALUE;
        for(String s:set){
            String[] strs=s.split(" ");
            x0=Math.min(Integer.valueOf(strs[0]),x0);
            x1=Math.max(Integer.valueOf(strs[0]),x1);
            y0=Math.min(Integer.valueOf(strs[1]),y0);
            y1=Math.max(Integer.valueOf(strs[1]),y1);
        }
        return sumArea==(y1-y0)*(x1-x0);
    }
    public int Area(int[] rec){
        return (rec[3]-rec[1])*(rec[2]-rec[0]);
    }
}