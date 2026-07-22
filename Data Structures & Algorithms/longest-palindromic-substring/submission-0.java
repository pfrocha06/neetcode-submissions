class Solution {
     public String longestPalindrome(String s) {
        int n = s.length();

        if (n <= 1) {
            return s;
        }

        boolean[][] dp = new boolean[n][n];

        int bestStart = 0;
        int bestLength = 1;

        for (int length = 1; length <= n; length++) {
            for (int left = 0; left + length <= n; left++) {
                int right = left + length - 1;

                if (length == 1) {
                    dp[left][right] = true;
                } else if (length == 2) {
                    dp[left][right] =
                        s.charAt(left) == s.charAt(right);
                } else {
                    dp[left][right] =
                        s.charAt(left) == s.charAt(right)
                        && dp[left + 1][right - 1];
                }

                if (dp[left][right] && length > bestLength) {
                    bestStart = left;
                    bestLength = length;
                }
            }
        }

        return s.substring(bestStart, bestStart + bestLength);
    }
}
