class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList();
        dfs (1, n, k, new ArrayList(), res);
        return res;
    }
    private void dfs (int start, int n, int k , List<Integer> list, List<List<Integer>> res) {
        if (n == 0 && k == 0) {
            res.add(new ArrayList(list));
            return;
        }
        if (n <=0 || k==0 || start > 9 ) {
            return;
        }
        list.add(start);
        dfs(start + 1, n - start, k - 1, list, res);
        list.remove(list.size() -1);
        dfs(start + 1, n , k, list, res);
    }
}