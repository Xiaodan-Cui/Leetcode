class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i< s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        boolean[] isFilled = new boolean[s.length()];
        List<String> res = new ArrayList();
        for(int letterNum = 1; letterNum <= map.size() ; letterNum++) {
            int i = 0;
            int j = 0;
            Map<Character, Integer> tempMap = new HashMap(map);
            Set<Character> set = new HashSet();
            while(j < s.length()){
                if(isFilled[j]){
                    while(j < s.length() && isFilled[j]){
                        j++;
                    }
                    i = j;
                    tempMap = new HashMap(map);
                    set = new HashSet();
                    continue;
                }
                set.add(s.charAt(j));
                tempMap.put(s.charAt(j), tempMap.get(s.charAt(j)) - 1);
                while(i < s.length() && set.size() > letterNum){
                    tempMap.put(s.charAt(i), tempMap.getOrDefault(s.charAt(i), 0) + 1);
                    if((int)tempMap.get(s.charAt(i)) == (int)map.get(s.charAt(i))){
                        set.remove(s.charAt(i));
                    }
                    i++;
                }
                if (tempMap.get(s.charAt(j)) == 0) tempMap.remove(s.charAt(j));
                if(set.size() == letterNum && map.size() - tempMap.size() == letterNum){
                    res.add(s.substring(i, j + 1));
                    for(int k = i; k<=j; k++){
                        isFilled[k] = true;
                    }
                    j++;
                    i = j;
                    tempMap = new HashMap(map);
                    set = new HashSet();
                    continue;
                }
                j++;
            }
        }
        return res;
        
    }
}