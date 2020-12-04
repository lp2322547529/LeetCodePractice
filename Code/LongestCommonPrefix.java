/**
 * @author:linpeng
 * @date:20201116
 * @version:v1.0
 */
public class LongestCommonPrefix {

    /**
     *
     * @param strs
     * @return
     *
     * Write a function to find the longest common prefix string amongst an array of strings.
     * If there is no common prefix, return an empty string "".
     *
     * Example
     * Input: strs = ["dog","racecar","car"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     *
     * Mark
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Longest Common Prefix.
     * Memory Usage: 37.3 MB, less than 52.07% of Java online submissions for Longest Common Prefix.
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length <= 0) {
            return "";
        }

        char[] common, current;
        String commonPrefix = strs[0];
        for(int i = 1; i < strs.length; i++) {
            int pos = 0;
            common = commonPrefix.toCharArray();
            current = strs[i].toCharArray();
            while (pos < common.length
                    && pos < current.length
                    && common[pos] == current[pos]) {
                pos++;
            }
            // 及时终止
            if(pos == 0 || "".equals(commonPrefix)) {
                return "";
            }
            commonPrefix = commonPrefix.substring(0, pos);
        }
        return commonPrefix;
    }

    public static void main(String[] args) {
        String[] strs = {"aab", "acabc", "aabd", "aabe"};
        System.out.println(longestCommonPrefix(strs));
    }
}
