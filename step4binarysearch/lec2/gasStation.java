package step4binarysearch.lec2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class gasStation {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 4;

        System.out.println(find(arr, k));
        System.out.println(findBetter(arr, k));
        System.out.println(findOpt(arr, k));
    }

    private static double findOpt(int[] arr, int k) {
        int n = arr.length;
        double low = 0, high = 0;

        for (int i = 0; i < n - 1; i++) {
            high = Math.max(high, arr[i + 1] - arr[i]);
        }

        while (high - low > (1e-6)) {
            double mid = (double) low + ((high - low) / 2.0);
            int rqr = rqr(arr, mid);

            if (rqr > k) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return high;
    }

    private static int rqr(int[] arr, double k) {
        int ans = 0, n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            double nb = (arr[i + 1] - arr[i]) / k;
            if (nb == (int) nb * k) {
                nb--;
            }
            ans += (int) nb;
        }
        return ans;
    }

    private static double findBetter(int[] arr, int k) {

        int n = arr.length;
        PriorityQueue<Pair> tm = new PriorityQueue<>(
                (a, b) -> Double.compare(b.distance, a.distance)
        );

        for (int i = 0; i < n - 1; i++) {
            tm.add(new Pair((double) arr[i + 1] - arr[i], i));
            System.out.println((double) arr[i + 1] - arr[i] + " :: " + i);
        }

        int[] hm = new int[n - 1];
        for (int i = 1; i <= k; i++) {
            double bs = tm.peek().distance;
            int inx = tm.peek().index;

            tm.poll();

            hm[inx]++;
            tm.add(new Pair(((double) arr[inx + 1] - arr[inx]) / (hm[inx] + 1) * 1.0, inx));
        }
        System.out.println(Arrays.toString(hm));

        return tm.peek().distance;
    }

    private static double find(int[] arr, int k) {

        int n = arr.length;
        int[] hm = new int[n - 1];
        for (int i = 1; i <= k; i++) {
            double maxSection = -1;
            int maxInx = -1;
            for (int j = 0; j < n - 1; j++) {
                //max section gotva no code
                double diff = (double) arr[j + 1] - arr[j];
                System.out.println(diff);
                double sectionLength = diff * 1.0 / (hm[j] + 1.0);

                if (sectionLength > maxSection) {
                    maxSection = sectionLength;
                    maxInx = j;
                }
            }

            hm[maxInx]++;

        }

        System.out.println(Arrays.toString(hm));
        double max = -1.0;
        for (int i = 0; i < n - 1; i++) {
            double diff = (arr[i + 1] - arr[i]) / (hm[i] + 1.0);
            if (diff > max) {
                max = diff;
            }
        }
        return max;
    }
}

class Pair {

    double distance;
    int index;

    Pair(double distance, int index) {
        this.distance = distance;
        this.index = index;
    }
}
