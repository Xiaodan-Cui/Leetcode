class Solution {
    public int getWinner(int[] arr, int k) {
        int[] less = new int[arr.length];
        int i = 0;
        int max = 0;
        int count = 0;
        while(i < arr.length){
            max = Math.max(max, arr[i]);
            if (k == count) return max;
            int j = i + 1;
            while(j < arr.length && arr[j] < arr[i]){
                count++;
                if (count == k){
                    return arr[i];
                }
                j++;
            }
            count = 1;
            i = j;
        }
        return max;
    }
}
