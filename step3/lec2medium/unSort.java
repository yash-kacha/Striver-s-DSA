package step3.lec2medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class unSort {
    public static void main(String[] args) {

        int[] in = new int[] { 1, 5, 99, 22, 10, 22, 30, 2, 3, 6, 4, 30 };

        System.out.println(Arrays.toString(in));
        unsort(in);
        System.out.println(Arrays.toString(in));
    }

    public static void unsort(int[] x) {
        Map<Double, Integer> temp = new HashMap<>();

        Random rd = new Random();

        for (int i : x) {
            temp.put(rd.nextDouble(x.length), i);
        }

        // for (Map.Entry<Double, Integer> i : temp.entrySet()) {
        // x[po] = i.getValue();
        // }

        temp = new TreeMap<>(temp);

        int po = 0;
        for (Map.Entry<Double, Integer> i : temp.entrySet()) {
            x[po] = i.getValue();
            po++;
        }

    }
}
