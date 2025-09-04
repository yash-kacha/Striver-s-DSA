package step1.lec5recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fiboPlusMemorizationPlusRecursion {
    public static void main(String[] args) {
        List<Integer> op = new ArrayList<>();
        op.add(1);
        op.add(11);
        op.add(21);
        op.add(31);
        op.add(44);
        op.add(404);
        op.add(4);
        System.out.println(op.toString());

        Map<Integer, Double> temp = new HashMap<>();
        temp.put(0, 0.0);
        temp.put(1, 1.0);
        for (int i = 0; i <= 50; i++)
            System.out.println("ith : " + i + " : " + fib(i, temp));
    }

    public static Double fib(int n, Map<Integer, Double> temp) {

        if (temp.containsKey(n))
            return temp.get(n);

        double ans = fib(n - 1, temp) + fib(n - 2, temp);
        temp.put(n, ans);
        return ans;

    }
}
