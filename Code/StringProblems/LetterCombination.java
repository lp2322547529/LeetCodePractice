package StringProblems;

import java.util.*;

/**
 * @author:linpeng
 * @date:20201117
 * @version:v1.0
 */
public class LetterCombination {

    /**
     *
     * @param digits
     * @return all possible letter combinations that the number could represent
     *
     * Given a string containing digits from 2-9 inclusive
     * A mapping of digit to letters (just like on the telephone buttons) is given below.
     * Note that 1 does not map to any letters.
     *
     * Example
     * input："23"
     * output：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     *
     * Mark
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Letter Combinations of a Phone Number.
     * Memory Usage: 37.6 MB, less than 88.77% of Java online submissions for Letter Combinations of a Phone Number.
     */
    public static List<String> letterCombinations(String digits) {
        if(digits == null || "".equals(digits)) {
            return new ArrayList<>();
        }

        char[] arr = digits.toCharArray();
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        HashMap<Character, String> map = new HashMap<>(8);
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        getCombination(0, arr, map, res, sb);
        return res;
    }

    private static void getCombination(int pos, char[] arr, Map<Character, String> map, List<String> res, StringBuilder sb) {
        if(pos == arr.length) {
            if(sb.length() != 0) {
                res.add(sb.toString());
            }
            return;
        }

        for(char c : map.get(arr[pos]).toCharArray()) {
            sb.append(c);
            getCombination(pos + 1, arr, map, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        String s = "2423";
        System.out.println(letterCombinations(s));
    }
}
