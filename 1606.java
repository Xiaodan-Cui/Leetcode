class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] counts = new int[k];
        TreeSet<Integer> servers = new TreeSet();
        for(int i = 0; i < k; i++) servers.add(i);
        PriorityQueue<int[]> endTimes = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        int i = 0;
        int currTime = arrival[0];
        while(true){
            while(i < arrival.length && currTime > arrival[i]) i++;
            if (i == arrival.length) break;
            while(endTimes.size() > 0 && endTimes.peek()[1] <= currTime){
                int[] out = endTimes.poll();
                servers.add(out[0]);
            }
            if (servers.size() != 0){
                Integer server = servers.ceiling(i % k);
                if (server == null) server = servers.first();
                counts[server]++;
                servers.remove(server);
                endTimes.add(new int[]{server,currTime + load[i]});
            }
            i++;
            if (i < arrival.length){
                currTime = arrival[i];
            }
        }
        int max = 0;
        List<Integer> list = new ArrayList();
        for(int j = 0;j < k; j++){
            if (counts[j] > max){
                list.clear();
                list.add(j);
                max = counts[j];
            }
            else if (counts[j] == max) list.add(j);
        }
        return list;                                                                             
    }
}