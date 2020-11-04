/**
 * @author:linpeng
 * @date:20201103
 * @version:v1.0
 */
public class LongestPalindrome {

    /**
     *
     * @param s
     * @return the longest palindromic substring in s.
     *
     * Example
     * Input: s = "babad"
     * Output: "bab"
     * Note: "aba" is also a valid answer.
     *
     * Mark
     * Runtime: 29 ms, faster than 52.84% of Java online submissions for Longest Palindromic Substring.
     * Memory Usage: 39.5 MB, less than 5.40% of Java online submissions for Longest Palindromic Substring.
     */
    public static String longestPalindrome(String s) {
        if(s == null || "".equals(s) || s.length() <= 1) {
            return s;
        }

        String result = "";
        for(int i = 0; i < s.length(); i++) {
            String s1 = palindrome(s, i, i);
            String s2 = palindrome(s, i, i+1);

            result = result.length() >= s1.length() ? result : s1;
            result = result.length() >= s2.length() ? result : s2;
        }
        return result;
    }

    private static String palindrome(String s, int i, int j) {
        while(i >= 0 && j < s.length()
                && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }

        return s.substring(i+1, j);
    }


    // 参考discuss
    public static String longestPalindrome(String s, String t) {
        if(s == null || s.length() <= 1) {
            return s;
        }

        int maxLength = 0, start = -1;
        int length = s.length();
        char[] charArray = s.toCharArray();
        boolean[][] dp = new boolean[length][length];

        // 初始化：对角线即i = j时指向的是同一个位置，必定为true;
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }

        // 遍历
        for(int j = 1; j < length; j++) {
            for(int i = 0; i < j; i++) {
                if(charArray[i] == charArray[j]) {
                    if(j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                } else {
                    dp[i][j] = false;
                }

                if (dp[i][j]) {
                    if (maxLength < j-i+1) {
                        maxLength = j-i+1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start+maxLength);
    }

    public static void main(String[] args) {
        String s = "cabccbad";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome(s, ""));
    }
}
