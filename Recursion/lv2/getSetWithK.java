package Recursion.lv2;

import java.util.ArrayList;
import java.util.List;

public class getSetWithK {

    public static void main(String[] args) {
        int n = 5;
        int sum = 20;

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();

        getAns(n, sum, result, temp, 0);

        for (List<Integer> i : result) {
            System.out.println(i.toString());
        }

    }

    public static void getAns(int n, int sum, List<List<Integer>> result, List<Integer> temp, int i) {
        System.out.println("issue");
        if (i == sum && temp.size() == n) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (i > sum || temp.size() > n) {

            return;
        }

        for (int jj = !temp.isEmpty() ? temp.get(temp.size() - 1) + 1 : 1; jj <= sum - i; jj++) {
            temp.add(jj);

            getAns(n, sum, result, temp, i + jj);
            temp.remove(temp.size() - 1);
        }
    }
}
