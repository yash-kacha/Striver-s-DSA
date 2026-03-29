package Recursion.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class getSumOfAllSubSet {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        List<Integer> sum = new ArrayList<>();
        List<Integer> in = new ArrayList<>();

        for (int i : arr) {
            in.add(i);
        }

        getAllSum(in, sum, 0);
        Collections.sort(sum);
        System.out.println(sum.toString());

    }

    private static void getAllSum(List<Integer> in, List<Integer> sum, int s) {

        if (in.isEmpty()) {

            sum.add(s);
            return;
        }

        int ele = in.get(0);
        in.remove(0);
        getAllSum(in, sum, s + ele);

        getAllSum(in, sum, s);

        in.add(0, ele);
    }
}
