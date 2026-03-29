package medium;

public class maxDepthParentheses {

    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(maxDepth(s));
    }

    private static int maxDepth(String s) {
        int cnt = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
                if (cnt > max) {
                    max = cnt;
                }
            } else if (s.charAt(i) == ')') {
                cnt--;
            }
        }
        return max;
    }
}
