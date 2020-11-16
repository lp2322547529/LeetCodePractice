import java.util.HashMap;

/**
 * @author:linpeng
 * @date:20201116
 * @version:v1.0
 */
public class RomanToInteger {

    /**
     * Given a roman numeral, convert it to an integer.
     *
     * @param s
     * @return integer
     *
     * Example
     * Input: s = "LVIII"
     * Output: 58
     * Explanation: L = 50, V= 5, III = 3.
     *
     * Mark
     * Runtime: 5 ms, faster than 58.70% of Java online submissions for Roman to Integer.
     * Memory Usage: 39.7 MB, less than 27.50% of Java online submissions for Roman to Integer.
     */
    public static int romanToInt(String s) {
        if(s == null || "".equals(s)) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>(7);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        char current, last = 0;
        char[] strArr = s.toCharArray();

        for(int i = strArr.length - 1; i >= 0; i--){
            current = strArr[i];
            if (((last == 'V' || last == 'X') && current == 'I') || ((last == 'L' || last == 'C') && current == 'X')
                    || ((last == 'D' || last == 'M') && current == 'C')) {
                result -= map.get(current);
            } else {
                result += map.get(current);
            }
            last = current;
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "MDCXLXIVI";
        System.out.println(romanToInt(s));
    }
}
