class Solution {
    public double minmaxGasDist(int[] stations, int k) {
        double[] dis =new double[stations.length-1];
        double max=0;
        for(int i=0;i<dis.length;i++){
            dis[i]=(double)(stations[i+1]-stations[i]);
            max=Math.max(dis[i],max);
        }
        return binarySearch(dis,0.0,max,k);
    }
    private double binarySearch(double[] dis,double min, double max,int k){
        if(min>max) return max;
        double mid=min+(max-min)/2;
        int n=0;
        int i=0;
        double[] dis_c=dis.clone();
        while(i<dis.length){
            if(dis_c[i]>mid){
                dis_c[i]-=mid;
                n++;
            }
            else{
                i++;
            }
        }
        if(n>k) return binarySearch(dis,mid+1e-6,max,k);
        return binarySearch(dis,min,mid-1e-6,k);
    }
}