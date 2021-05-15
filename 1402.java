class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int i = satisfaction.length - 1;
        if (satisfaction[i] <= 0) return 0;
        int sum = 0;
        int res = 0;
        while(i >= 0) {
            if(satisfaction[i] + sum <= 0) return res;
            sum += satisfaction[i];
            res += sum;
            i--;
            
        }
        return res;
    }
}