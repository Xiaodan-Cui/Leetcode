/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int row = rand7();
        int col = rand7();
        while((row - 1) * 7 + col > 40){
            row = rand7();
            col = rand7();
        }
        if (((row - 1) * 7 + col) % 10 == 0) return 10;
        return ((row - 1) * 7 + col) % 10;
    }
}