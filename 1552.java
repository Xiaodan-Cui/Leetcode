class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int max = (position[position.length - 1] - position[0] ) / (m - 1);
        return binarySearch(position, m, 1, max);
    }
    private int binarySearch(int[] position, int m, int start, int end){
        if (start > end) return end;
        int mid = start + (end - start) / 2;
        int count = 1;
        int i = 0;
        int before = 0;
        while(i < position.length){
            while(i < position.length && position[i] - position[before] < mid){
                i++;
            }
            if (i < position.length) {
                count++;
                before = i;
            }
        }
        if (count >= m) return binarySearch(position, m, mid + 1, end);
        return binarySearch(position, m, start, mid - 1);
    }
}