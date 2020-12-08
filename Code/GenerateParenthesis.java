import java.util.ArrayList;
import java.util.List;

/**
 * @author:linpeng
 * @date:20201206
 * @version:v1.0
 */
public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        generatePair(result, "", n, n);

        return result;
    }

    public static void generatePair(List<String> result, String temp, int left, int right) {
        if(left > right) {
            return;
        }
        if(left == 0 && right == 0) {
            result.add(temp);
            return;
        }
        if(left > 0) {
            generatePair(result, temp + "(", left - 1, right);
        }
        if(right > 0) {
            generatePair(result, temp + ")", left, right - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
}
