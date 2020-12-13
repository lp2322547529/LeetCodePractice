package StringProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:linpeng
 * @date:20201101
 * @version:v1.0
 */
public class LongestSubstringWithoutRepeat {

    /**
     *
     * @param s
     * @return the length of the longest substring without repeating characters
     *
     * Example
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
     *
     * Mark:
     * Runtime: 4 ms, faster than 90.41% of Java online submissions for Longest Substring Without Repeating Characters.
     * Memory Usage: 39.1 MB, less than 6.46% of Java online submissions for Longest Substring Without Repeating Characters.
     */
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || "".equals(s)) {
            return 0;
        }

        // i,j是两个指针,i随for循环增大，一旦遇到以前有的字符则j向后移动
        // 如果需要知道最长字符串，则可以使用str保存，一旦res改变则重新赋值为 s[j+1, i]
        char c;
        int j = 0, res = 0;
        int length = s.length();
        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i < length; i++) {
            c = s.charAt(i);
            if(map.containsKey(c)) {
                j = Math.max(j, map.get(c));
            }

            map.put(c, i + 1);
            res = Math.max(res, i - j + 1 );
        }
        return res;
    }

    public static void main(String[] args) {
        String s = " abcxiwsssaa";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
