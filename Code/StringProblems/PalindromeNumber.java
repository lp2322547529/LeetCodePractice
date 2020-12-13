package StringProblems;

/**
 * @author:linpeng
 * @date:20201112
 * @version:v1.0
 */
public class PalindromeNumber {

    /**
     *
     * @param x
     * @return
     *
     * Determine whether an integer is a palindrome.
     * An integer is a palindrome when it reads the same backward as forward.
     *
     * Example
     * Input: x = -121
     * Output: false
     * Explanation: From left to right, it reads -121.
     * From right to left, it becomes 121-. Therefore it is not a palindrome.
     * String.valueOf(x).equals(new StringBuffer.append(x).reverse().toString())
     *
     * Mark
     * Runtime: 7 ms, faster than 67.23% of Java online submissions for Palindrome Number.
     * Memory Usage: 38.6 MB, less than 7.93% of Java online submissions for Palindrome Number.
     */
    public static boolean isPalindrome(int x) {
        char[] array = String.valueOf(x).toCharArray();
        int length = array.length;
        int middle = length / 2;
        for(int i =  0; i <= middle; i++) {
            if(array[i] != array[length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int x = -123454321;
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.append(x).reverse());
        System.out.println(isPalindrome(x));
    }
}
