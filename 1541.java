class Solution {
    public int minInsertions(String s) {
        int left = 0;
        int res = 0;
        int i = 0;
        while(i < s.length()){
            if (s.charAt(i) == '('){
                left++;
                i++;
            }
            else{
                if (i < s.length() - 1 && s.charAt(i + 1) == ')'){
                    if (left > 0){
                        left--;
                    }
                    else{
                        res++;
                    }
                    i += 2;
                }
                else{
                    if (left > 0){
                        res++;
                        left--;
                    }
                    else{
                        res += 2;
                    }
                    i++;
                }
            }
        }
        
        return res + 2 * left;

    }
}