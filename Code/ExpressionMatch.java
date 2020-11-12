/**
 * @author:linpeng
 * @date:20201112
 * @version:v1.0
 */
public class ExpressionMatch {

    /**
     *
     * @param s  string
     * @param p  pattern
     * @return
     *
     * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'
     * where:
     *  '.' Matches any single character.
     *  '*' Matches zero or more of the preceding element.
     *  The matching should cover the entire input string (not partial).
     *
     * Example
     * Input: s = "aab", p = "c*a*b"
     * Output: true
     * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
     *
     * 参考：
     * 1.P[i][j] = P[i - 1][j - 1], if p[j - 1] != '*' && (s[i - 1] == p[j - 1] || p[j - 1] == '.');
     * 2.P[i][j] = P[i][j - 2], if p[j - 1] == '*' and the pattern repeats for 0 times;
     * 3.P[i][j] = P[i - 1][j] && (s[i - 1] == p[j - 2] || p[j - 2] == '.'), if p[j - 1] == '*' and the pattern repeats for at least 1 times.
     *
     */
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        if(m == 0 && n == 0){
            return true;
        }
        if(n == 0){
            return false;
        }

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j > 1 && p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (i > 0 && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.') && dp[i - 1][j]);
                } else {
                    dp[i][j] = i > 0 && dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.');
                }
            }
        }

        return dp[m][n];
    }
}
