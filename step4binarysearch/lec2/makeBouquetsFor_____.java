package step4binarysearch.lec2;

import java.util.Arrays;

public class makeBouquetsFor_____ {
    public static void main(String[] args) {
        int[] roses = { 7, 7, 7, 7, 13, 11, 12, 7 };
        int bouquests = 2;
        int minRose = 3;

        System.out.println(findMinDays(roses, bouquests, minRose));
    }

    public static int findMinDays(int[] roses, int bouquests, int minRose) {

        int low = 0, high = Arrays.stream(roses).max().getAsInt();

        if (minRose * bouquests > roses.length)
            return -1;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            boolean canMake = canMake(roses, bouquests, minRose, mid);

            if (canMake) {
                low = mid + 1;
            } else {
                ans = Math.min(ans, mid);
                high = mid - 1;
            }
        }
        return low > Arrays.stream(roses).max().getAsInt() ? -1 : low;

    }

    public static boolean canMake(int[] roses, int bouquests, int minRose, int day) {
        int tempB = 0, tempRose = 0;

        for (int i : roses) {

            if (i <= day) {
                tempRose++;
            } else {
                tempRose = 0;
            }
            if (tempRose == minRose) {
                tempB++;
                tempRose = 0;
            }
        }
        return tempB < bouquests;
    }
}
