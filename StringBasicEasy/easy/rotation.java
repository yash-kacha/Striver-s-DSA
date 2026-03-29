package easy;

public class rotation {

    public static void main(String[] args) {
        String s = "rotation";
        String goal = "tionrota";

        System.out.println(check(s, goal));
    }

    private static boolean check(String s, String goal) {

        int n = s.length();
        int m = goal.length();
        if (n != m) {
            return false;
        }

        boolean ans = false;
        for (int i = 0; i < n; i++) {

            if (isrotation(s, goal, i)) {
                return true;
            }
            // System.out.println("\nisroation : " + isrotation(s, goal, i) + " : " + i);
        }
        return false;
    }

    public static boolean isrotation(String s, String goal, int n) {
        // System.out.println("for string : " + s + " :: " + n);
        for (int i = 0; i < s.length(); i++) {
            int j = (i + n) % s.length();
            // System.out.printf("we get %d , %d \n", i, j);
            if (s.charAt(i) != goal.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
