class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        if (dist.length > Math.ceil(hour)) return -1;
        int max = 0;
        for(int d : dist){
            max = Math.max(d, max);
        }
        return bs(dist, hour, 1, Math.max(max, dist[dist.length - 1] * 100));
    }
    public int bs(int[] dist, double hour, int min, int max){
        if(min > max) return min;
        int mid = min + (max - min) / 2;
        double sum = 0;
        for(int i = 0; i < dist.length - 1; i++){
            sum += Math.ceil((double)dist[i] / mid);
        }
        sum += (double)dist[dist.length - 1] / mid;
        if (sum <= hour) return bs(dist, hour, min, mid - 1);
        return bs(dist, hour, mid + 1, max);
    }
}