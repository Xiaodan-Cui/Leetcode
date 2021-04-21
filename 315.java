class Solution {
    List<Integer> res = new ArrayList();
    List<Integer> after = new ArrayList();
    public List<Integer> countSmaller(int[] nums) {
        for(int i = nums.length - 1; i >= 0; i--){
            int j = search(nums[i], nums, 0, after.size() - 1);
            after.add(j , nums[i]);
            res.add(0, j);
        }
        return res;
    }
    private int search(int n, int[] nums, int start, int end) {
        if (start > end) return start;
        if (n <= after.get(start)) return start;
        if (n >after.get(end)) return end + 1;
        int mid = start + (end - start) / 2;
        if (n <= after.get(mid)) return search(n, nums, start, mid - 1);
        return search(n, nums, mid + 1, end);
    }
}