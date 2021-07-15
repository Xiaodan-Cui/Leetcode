class Solution {
    int count = 0;
    public int maxUniqueSplit(String s) {
        dfs(s, 0, new HashSet());
        return count;
    }
    
    private void dfs(String s, int start, Set<String> visited){
        if (start == s.length()){
            if (visited.size() > count){
                count = visited.size();
            }
            return;
        }
        for(int i = start; i < s.length() && s.length() - i + visited.size() > count; i++){
            String temp = s.substring(start, i+ 1);
            if (visited.contains(temp)){
                continue;
            }
            visited.add(temp);
            dfs(s, i + 1, visited);
            visited.remove(temp);
        }
    }
}
