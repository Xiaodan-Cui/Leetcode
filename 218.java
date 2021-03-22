class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>>res= new ArrayList();
        int[][] lines=new int[buildings.length*2][3];
        for(int i=0;i<buildings.length;i++){
            lines[i*2][0]=buildings[i][0];
            lines[i*2][1]=1;
            lines[i*2][2]=buildings[i][2];
            lines[i*2+1][0]=buildings[i][1];
            lines[i*2+1][1]=-1;
            lines[i*2+1][2]=buildings[i][2];
        }
        Arrays.sort(lines,(a,b)->a[0]-b[0]);
        Map<Integer,Integer> map=new HashMap();
        PriorityQueue<Integer> PQ=new PriorityQueue<>((a,b)->b-a);
        int currentX=lines[0][0];
        int currentY=lines[0][2];
        map.put(0,1);
        PQ.add(0);
        for(int i=0;i<lines.length;i++){
            while(!PQ.isEmpty() && map.get(PQ.peek())==0){
                    PQ.poll();
            }
            if(currentX!=lines[i][0]){
                //System.out.println(currentY);
                if(currentY>=PQ.peek()){
                    if(res.size()==0 || PQ.peek()!=res.get(res.size()-1).get(1)){
                    List<Integer> temp=new ArrayList();
                    temp.add(currentX);
                    temp.add(PQ.peek());
                    res.add(temp);
                    }
                }
                currentX=lines[i][0];
                currentY=lines[i][2];
                
            }
            if(lines[i][1]==1){
                if(!map.containsKey(lines[i][2])|| map.get(lines[i][2])==0){
                    PQ.add(lines[i][2]);
                }
                //System.out.println(lines[i][2]);
                map.put(lines[i][2],map.getOrDefault(lines[i][2],0)+1);
            }
            else{
                map.put(lines[i][2],map.get(lines[i][2])-1);
            }
            currentY=Math.max(currentY,lines[i][2]);
        }
        List<Integer> temp=new ArrayList();
        temp.add(lines[lines.length-1][0]);            
        temp.add(0);
        res.add(temp); 
        return res;  
    }
}