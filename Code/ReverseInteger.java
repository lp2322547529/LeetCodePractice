/**
 * @author:linpeng
 * @date:20201111
 * @version:v1.0
 */
public class ReverseInteger {

    /**
     * 光棍节快乐！！！（单人住的程序猿之吼）
     *
     * @param x
     * @return reverse digits of an integer.
     *
     * Example
     * Input: x = -123
     * Output: -321
     * Assume we are dealing with an environment that could only store integers
     *  within the 32-bit signed integer range: [−231,  231 − 1].
     *  For the purpose of this problem, assume that your function
     *  returns 0 when the reversed integer overflows.
     *
     * Mark
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Reverse Integer.
     * Memory Usage: 35.8 MB, less than 8.53% of Java online submissions for Reverse Integer.
     * Next challenges:
     */
    public static int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
        x = Math.abs(x);

        long result = 0;
        while(x > 0) {
            result = result * 10 + (x % 10);
            x = x / 10;
        }

        result = sign * result;
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            result = 0;
        }

        return (int)result;
    }

    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(reverse(x));
    }
}
