class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int val1 = 1;
        int val2 = 2;

        for (int i = 3; i <= n ; i++){
            int current = val1 + val2;

            val1 = val2;
            val2 = current;
        }

        return val2;
    }
}
