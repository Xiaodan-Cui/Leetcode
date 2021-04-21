class Solution {
    long res = 0;
    List<Integer> list = new ArrayList();
    final int mod = 1000000007;
    public int createSortedArray(int[] instructions) {
        for(int i = 0; i < instructions.length; i++) {
            int left = findLeft(instructions[i], list, 0, list.size() - 1);
            int right = findRight(instructions[i], list, left, list.size() - 1);
            list.add(left, instructions[i]);
            res += Math.min(left, right);
            res %= mod;
        }
        return (int)res;
    }
    private int findLeft(int n, List<Integer> list, int start, int end) {
        if (start > end) return start;
        if (n <= list.get(start)) return start;
        if (n > list.get(end)) return end + 1;
        int mid = start + (end - start) / 2;
        if (n <= list.get(mid)) {
            return findLeft(n, list, start, mid - 1);
        }
        return findLeft(n, list, mid + 1, end);
    }
    private int findRight(int n, List<Integer> list, int start, int end) {
        if (start > end) return list.size() - start;
        if (n < list.get(start)) return list.size() - start;
        if (n >= list.get(end)) return list.size() - end - 1;
        int mid = start + (end - start) / 2;
        if (n < list.get(mid)) {
            return findRight(n, list, start, mid - 1);
        }
        return findRight(n, list, mid + 1, end);
    }
}