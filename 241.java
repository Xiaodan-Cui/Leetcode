class Solution {
    List<Integer>[][] memo;
    public List<Integer> diffWaysToCompute(String input) {
        if (input.length() == 0) return new ArrayList();
        memo= new ArrayList[input.length()][input.length()];
        return helper(input, 0, input.length() - 1);
        
    }
    
    private List<Integer> helper(String input, int start, int end){
        if (memo[start][end] != null) return memo[start][end];
        List<Integer> res = new ArrayList();
        boolean pureNum = true;
        for(int i = start; i <= end; i++){
            if (input.charAt(i) == '-'){
                List<Integer> left = helper(input, start, i - 1);
                List<Integer> right = helper(input, i + 1, end);
                for(int l : left){
                    for(int r : right){
                        res.add(l - r);
                    }
                }
                pureNum = false;
            }
            else if (input.charAt(i) == '+'){
                List<Integer> left = helper(input, start, i - 1);
                List<Integer> right = helper(input, i + 1, end);
                for(int l : left){
                    for(int r : right){
                        res.add(l + r);
                    }
                }
                pureNum = false;
            }
            else if (input.charAt(i) == '*'){
                List<Integer> left = helper(input, start, i - 1);
                List<Integer> right = helper(input, i + 1, end);
                for(int l : left){
                    for(int r : right){
                        res.add(l * r);
                    }
                }
                pureNum = false;
            }
        }
        if (pureNum) res.add(Integer.valueOf(input.substring(start, end + 1)));
        memo[start][end] = res;
        return res;
    }
}