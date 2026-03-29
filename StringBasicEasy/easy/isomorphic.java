package easy;

public class isomorphic {

    public static void main(String[] args) {
        String s = "paper";
        String t = "title";

        System.out.println(check(s, t));
    }

    private static boolean check(String s, String t) {
        int[] c1 = new int[256];
        int[] c2 = new int[256];

        for (int i = 0; i < s.length(); i++) {
            int cu1 = s.charAt(i);
            int cu2 = t.charAt(i);

            if (c1[cu1] == 0 && c2[cu2] == 0) {
                c1[cu1] = cu2;
                c2[cu2] = cu1;
            } else if (c1[cu1] == cu2 && c2[cu2] == cu1) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}
