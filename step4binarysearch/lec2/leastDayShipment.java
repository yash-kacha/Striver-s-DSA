package step4binarysearch.lec2;

import java.util.Arrays;

public class leastDayShipment {
    public static void main(String[] args) {
        int[] weight = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int day = 1;

        System.out.println(minDaysShip(weight, day));
    }

    public static int minDaysShip(int[] weight, int day) {
        int low = 1, high = Arrays.stream(weight).sum();

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (findLimit(weight, mid, day)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;

    }

    public static boolean findLimit(int[] in, int weight, int limit) {

        int day = 0, mass = 0;
        for (int i = 0; i < in.length; i++) {
            mass += in[i];

            if (mass > weight) {
                day++;
                mass = 0;
                i--;
            }
            if (day >= limit)
                return false;
        }

        System.out.println("for weight : " + weight + " it takes days : " + (day + 1));
        return true;
    }

}
