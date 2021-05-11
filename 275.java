class Solution {
    public int hIndex(int[] citations) {
        return find(citations, 0, citations.length - 1);
    }
    
    private int find(int[] citations, int start, int end){
        if (start > end) return citations.length - start;
        int mid = start + (end - start) /2;
        if (citations[mid] >= citations.length - mid) {
            return find(citations, start, mid - 1);
        }
        return find(citations, mid + 1, end);
    }
}