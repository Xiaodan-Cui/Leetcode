class Solution {
    public boolean isSolvable(String[] words, String result) {
        Map<Character, Integer> map = new HashMap();
        Set<Integer> lead = new HashSet();
        int[] count = new int[10];
        int index = 0;
        for(String w : words){
            for(int i = 0; i < w.length(); i++){
                char temp = w.charAt(i);
                int number = (int)Math.pow(10, w.length() - i - 1);
                if (map.containsKey(temp)){
                    count[map.get(temp)] += number;
                }
                else{
                    map.put(temp, index);
                    count[index++] = number;
                }
                if (i == 0 && w.length() > 1){
                    lead.add(map.get(temp));
                }
            }
        }
        for(int i = 0; i < result.length(); i++){
            char temp = result.charAt(i);
            int number = (int)Math.pow(10, result.length() - i - 1);
            if (map.containsKey(temp)){
                count[map.get(temp)] -= number;
            }
            else{
                map.put(temp, index);
                count[index++] = -number;
            }
            if (i == 0 && result.length() > 1){
                lead.add(map.get(temp));
            }
        }
        return dfs(count,0, new boolean[10], 0, lead, index);
    }
    
    private boolean dfs(int[] count, int start, boolean[] state, int sum, Set<Integer> lead, int len){
        if (start == len){
            return sum == 0;
        }
        for(int i = 0; i <= 9; i++){
            if (i == 0 && lead.contains(start)) continue;
            if (!state[i]){
                state[i] = true;
                if (dfs(count, start + 1, state, sum + i * count[start], lead, len)){
                    return true;
                }
                state[i] = false;
            }
        }
        return false;
    }
}