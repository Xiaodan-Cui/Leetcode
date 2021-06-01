class Solution {
    public int longestAwesome(String s) {
        Map<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int curr = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            curr ^= 1<<(s.charAt(i) -'0');
            if (map.containsKey(curr)) max = Math.max(max, i - map.get(curr));
            for(int j = 0; j < 10; j++){
                if (map.containsKey(curr ^ 1<<j)) max = Math.max(max, i - map.get(curr ^ 1<< j));
            }
            if(!map.containsKey(curr)) map.put(curr, i);
        }
        return max;
        
    }
}