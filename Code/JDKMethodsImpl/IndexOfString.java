package JDKMethodsImpl;

/**
 * @author:linpeng
 * @date:20201213
 * @version:v1.0
 */
public class IndexOfString {

    public static int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) {
            return 0;
        }

        int p, q;
        char[] hay = haystack.toCharArray();
        char[] ne = needle.toCharArray();
        for(int i = 0; i < hay.length - ne.length + 1; i++) {
            p = i;
            q = 0;
            while(p < hay.length && q < ne.length && hay[p] == ne[q]) {
                p++;
                q++;
            }
            if(q == ne.length) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s = "aaaab";
        String b = "aab";
        System.out.println(strStr(s, b));
    }
}
