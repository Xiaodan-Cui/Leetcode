class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int[][] sum = new int[aliceValues.length][];
        for(int i = 0; i < aliceValues.length; i++){
            sum[i] = new int[]{aliceValues[i] + bobValues[i], aliceValues[i], bobValues[i]};
        }
        Arrays.sort(sum, (a, b) -> b[0] - a[0]);
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i < sum.length; i++){
            if (i % 2 == 0) sum1 += sum[i][1];
            else sum2 += sum[i][2];
        }
        return Integer.compare(sum1, sum2);
    }
    
}