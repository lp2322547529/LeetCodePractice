package JDKMethodsImpl;

/**
 * @author:linpeng
 * @date:20201213
 * @version:v1.0
 */
public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        if(divisor == 0) {
            throw new IllegalArgumentException("除法的被除数不允许为0！");
        }
        // 先确定符号，方便处理溢出的情况
        boolean flag = ((dividend >= 0 ? true : false) == (divisor >= 0 ? true : false));

        // 溢出的情况 min / -1
        if(dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // 转为正数进行计算
        long dd = (dividend == Integer.MIN_VALUE ? -(long)Integer.MIN_VALUE : Math.abs(dividend));
        long dr = (divisor == Integer.MIN_VALUE ? -(long)Integer.MIN_VALUE : Math.abs(divisor));

        int res = 0;
        while (dd >= dr) {
            int powerOfTwo = 1;
            long value = dr;

            while ((dd >> 1) >= value) {
                value = value << 1;
                powerOfTwo = powerOfTwo << 1;
            }

            res += powerOfTwo;
            dd -= value;
        }

        return flag ? res : -res;
    }

    public static void main(String[] args) {
        System.out.println(1 >> 1);
        System.out.println(divide(1, 1));
    }
}
