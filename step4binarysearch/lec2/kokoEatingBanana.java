package step4binarysearch.lec2;

public class kokoEatingBanana {
    public static void main(String[] args) {
        int[] in = new int[] { 30, 11, 23, 4, 20 };

        int hours = 5;

        System.out.println(minionMinBanana(in, hours));
    }

    public static int minionMinBanana(int[] in, int hours) {
        int size = in.length;
        int low = 1, high = in[size - 1];
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int compare = countHours(in, mid, hours);

            if (compare == 0) {
                low = mid + 1;
            } else {
                ans = Math.min(ans, mid);
                high = mid - 1;
            }

        }
        return ans;
    }

    public static int countHours(int[] in, int banana, int hours) {
        int ans = 0;
        for (int i : in) {
            ans += (i + banana - 1) / banana;
            if (ans > hours)
                return 0;
        }
        return 1;
    }
}
