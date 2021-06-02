class Solution {
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        int i = inventory.length - 1;
        int height = inventory[i];
        long res = 0;
        int mod = (int)1e9 + 7;
        while(orders > 0){
            while(i>=0 && inventory[i] >= height) i--;
            int pre = i == -1 ? 0 : inventory[i];
            int n = inventory.length - 1- i;
            long sum1 = (long)n * (height - pre);
            if (orders >= sum1){
                res += (sum1 * (height + pre + 1) / 2 ) % mod;
                height = pre;
                orders -= (int)sum1;
            }
            else{
                int d = orders/n;
                int r = orders % n;
                long sum2 = ((long)(height + height - d + 1) * d * n / 2) % mod;
                long sum3 = ((long)(height - d) * r) % mod;
                res = (res + sum2 + sum3) % mod;
                orders = 0;
            }

        }
        return (int)res;
    }
}