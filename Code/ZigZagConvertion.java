/**
 * @author:linpeng
 * @date:20201104
 * @version:v1.0
 */
public class ZigZagConvertion {

    /**
     *
     * @param s
     * @param numRows
     * @return zigzag string
     *
     * Example
     * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
     * P   A   H   N
     * A P L S I I G
     * Y   I   R
     * And then read line by line: "PAHNAPLSIIGYIR"
     * Write the code that will take a string and make this conversion given a number of rows:
     *
     * Mark
     * Runtime: 7 ms, faster than 47.52% of Java online submissions for ZigZag Conversion.
     * Memory Usage: 39.6 MB, less than 6.02% of Java online submissions for ZigZag Conversion.
     */
    public static String convert(String s, int numRows) {
        if(s == null || "".equals(s) || s.length() <= 1 || numRows == 1) {
            return  s;
        }

        int step = 1, pos = 0, target = 0;
        String result = "";
        StringBuilder[] sbArr = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
            sbArr[i] = new StringBuilder();
        }

        while(pos < s.length()) {
            sbArr[target].append(s.charAt(pos));
            target = target + step;
            if(target == 0 || target == numRows - 1) {
                step = -step;
            }
            pos++;
        }

        for(StringBuilder sb : sbArr) {
            result = result + sb.toString();
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, 3));
    }
}
