package JDKMethodsImpl;

import javax.xml.stream.events.Characters;

/**
 * @author:linpeng
 * @date:20201111
 * @version:v1.0
 */
public class Atoi {

    /**
     *
     * @param s
     * @return
     *
     * Implement atoi which converts a string to an integer.
     * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
     * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
     * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
     * If no valid conversion could be performed, a zero value is returned.
     *
     * Note:
     * Only the space character ' ' is considered a whitespace character.
     * Assume we are dealing with an environment that could only store integers
     * within the 32-bit signed integer range: [−231,  231 − 1].
     * If the numerical value is out of the range of representable values,
     * INT_MAX (231 − 1) or INT_MIN (−231) is returned.
     *
     * Example
     * Input: str = "4193 with words"
     * Output: 4193
     * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
     *
     * Mark
     * Runtime: 6 ms, faster than 14.76% of Java online submissions for String to Integer (atoi).
     * Memory Usage: 39.5 MB, less than 24.96% of Java online submissions for String to Integer (atoi).
     */
    public static int myAtoi(String s) {
        if (s == null || "".equals(s)
                || (s = s.trim()).length() <= 0) {
            return 0;
        }

        int sign = 0;
        char c = s.charAt(0);
        if (c == '+' || c == '-') {
            // 正负号开头，之后的第一个字符不是数字
            if (s.length() <= 1 || !Character.isDigit(s.charAt(1))) {
                return 0;
            }
            if (c == '+') {
                sign = 1;
            } else {
                sign = -1;
            }
            s = s.substring(1);
        } else if (Character.isDigit(c)) {
            sign = 1;
        } else {
            return 0;
        }

        long result = 0;
        char[] array = s.toCharArray();
        for(char i : array) {
            if(Character.isDigit(i)) {
                result = result * 10 + Integer.valueOf(i + "");
                if(sign == 1 && (result * sign) > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if(sign == -1 && (result * sign) < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }
        }

        result = result * sign;
        return (int)result;
    }

    public static void main(String[] args) {
        String s = "9223372036854775808";
        System.out.println(myAtoi(s));
    }
}
