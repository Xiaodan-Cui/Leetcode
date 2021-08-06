class Solution {
    TreeMap<Integer, Integer> weights = new TreeMap();
    int[][] rects;
    Random rand = new Random();
    int total = 0; 
    public Solution(int[][] rects) {
        this.rects = rects;
        for(int i = 0; i < rects.length; i++){
            weights.put(total, i);
            total += area(rects[i]);
            //System.out.println(total);
        }
    }
    
    public int[] pick() {
        int randomNum = rand.nextInt(total);
        int index = weights.get(weights.floorKey(randomNum));
        int[] rect = rects[index];
        int x = rand.nextInt(rect[2] - rect[0] + 1) + rect[0];
        int y = rand.nextInt(rect[3] - rect[1] + 1) + rect[1];
        return new int[]{x, y};
        
    }
    
    private int area(int[] rect){
        return (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */