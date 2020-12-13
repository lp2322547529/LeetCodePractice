package RealitySituation;

/**
 * @author:linpeng
 * @date:20201115
 * @version:v1.0
 */
public class IntegerToRoman {

    /**
     *
     * @param num
     * @return
     *
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * Roman numerals are usually written largest to smallest from left to right.
     * However, the numeral for four is not IIII.
     * Instead, the number four is written as IV.
     * Because the one is before the five we subtract it making four.
     * The same principle applies to the number nine, which is written as IX.
     * There are six instances where subtraction is used:
     *
     * Example
     * Input: num = 1994
     * Output: "MCMXCIV"
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     *
     * Mark
     * Runtime: 5 ms, faster than 56.79% of Java online submissions for Integer to Roman.
     * Memory Usage: 38.6 MB, less than 67.75% of Java online submissions for Integer to Roman.
     */
    public static String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbtemp = new StringBuilder();
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        for (int i = 0; i < values.length; i++) {
            int r = num / values[i];
            sb.append(getRepeatString(sbtemp, symbols[i], r));
            num -= r * values[i];
        }

        return sb.toString();
    }

    private static String getRepeatString(StringBuilder sb, String s, int r) {
        sb.setLength(0);
        while(r > 0) {
            sb.append(s);
            r--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int num = 1994;
        System.out.println(intToRoman(num));
    }
}
