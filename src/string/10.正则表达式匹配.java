/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        int ls = s.length(), lp = p.length();
        boolean[][] dp = new boolean[ls+1][lp+1];
        dp[0][0] = true;
        for (int i=2;i <= lp;i++) {
            dp[0][i] = dp[0][i-2] && p.charAt(i-1) == '*';
        }
        for (int i=1;i <= ls;i++) {
            for (int j=1;j <= lp;j++) {
                int m = i - 1, n = j - 1;
                if(p.charAt(n) == '*')
                    dp[i][j] = dp[i][j - 2] || dp[i - 1][j] && 
                        (s.charAt(m) == p.charAt(n - 1) || p.charAt(n - 1) == '.');
                else if(s.charAt(m) == p.charAt(n) || p.charAt(n) == '.') 
                    dp[i][j] = dp[i - 1][j - 1];
            }
        }
        return dp[ls][lp];
    }
}
// @lc code=end

