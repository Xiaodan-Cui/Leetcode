class Solution {
    public int findTheLongestSubstring(String s) {
        int[][] counts = new int[5][s.length() + 1];
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < 5; j++){
                counts[j][i] = counts[j][i - 1];
            }
            if (s.charAt(i - 1) == 'a') counts[0][i] = counts[0][i - 1] + 1;
            else if (s.charAt(i - 1) == 'e') counts[1][i] = counts[1][i - 1] + 1;
            else if (s.charAt(i - 1) == 'i') counts[2][i] = counts[2][i - 1] + 1;
            else if (s.charAt(i - 1) == 'o') counts[3][i] = counts[3][i - 1] + 1;
            else if (s.charAt(i - 1) == 'u') counts[4][i] = counts[4][i - 1] + 1;
        }
        int res = s.length();
        while(res >= 0 ){
            for(int i = 0; i + res <= s.length(); i++){
                int n0 = counts[0][res + i] - counts[0][i];
                int n1 = counts[1][res + i] - counts[1][i];
                int n2 = counts[2][res + i] - counts[2][i];
                int n3 = counts[3][res + i] - counts[3][i];
                int n4 = counts[4][res + i] - counts[4][i];
                if (n0 % 2 == 0 && n1 % 2 == 0 && n2 % 2 == 0 && n3 % 2 ==0 && n4 % 2 == 0) {
                    return res;
                }
            }
            res--;
        }
        return res;
    }
}