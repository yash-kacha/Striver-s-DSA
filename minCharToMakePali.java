
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class minCharToMakePali {

    public static void main(String[] args) {
        String s = "aebcbda";
        System.out.println(solve(s));
    }

    private static int solve(String s) {
        int n = s.length();
        List<Character> ss = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());

        int cnt = 0;
        int low = 0, high = n - 1;

        while (low < high) {
            if (ss.get(low) == ss.get(high)) {
                continue;
            }

        }
    }
}
