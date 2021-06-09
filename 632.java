class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        Queue<int[]> queue = new LinkedList();
        for(int i = 0; i < nums.get(0).size(); i++){
            queue.add(new int[]{nums.get(0).get(i),nums.get(0).get(i)});
        }
        for(int i = 1; i < nums.size(); i++){
            List<Integer> curr = nums.get(i);
            int j = 0;
            int k = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b){
                    if (b[1] != a[1]) return a[1] - b[1];
                    return b[0] - a[0];
                }
            });
            while(queue.size() > 0){
                int[] temp = queue.poll();
                while(j < curr.size() && curr.get(j) < temp[0]) j++;
                while(k < curr.size() && curr.get(k) < temp[1]) k++;
                if (j == 0 ) pq.add(new int[]{temp[0], Math.max(temp[1], curr.get(0))});
                else if (k == curr.size()) {
                    pq.add(new int[]{Math.min(temp[0], curr.get(curr.size() - 1)), temp[1]});
                }
                else if (j != k) pq.add(temp);
                else{
                    pq.add(new int[]{temp[0], curr.get(k)});
                    pq.add(new int[]{curr.get(j - 1), temp[1]});
                }
            }
            //queue.clear();
            int[] arr = new int[]{-100000, -100000};
            while(pq.size() > 0){
                int[] next = pq.poll();
                if (next[0] > arr[0]){
                    queue.add(next);
                    arr = next;
                }
            }    
        }
        int res = Integer.MAX_VALUE;
        int[] ans = new int[2];
        while(queue.size() > 0){
            int[] temp = queue.poll();
            if (temp[1] - temp[0] < res){
                res = temp[1] - temp[0];
                ans = temp;
            }
        }
        return ans;
    }
}